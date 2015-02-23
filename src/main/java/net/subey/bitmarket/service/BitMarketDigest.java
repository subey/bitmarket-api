package net.subey.bitmarket.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import si.mazi.rescu.RestInvocation;
import si.mazi.rescu.ParamsDigest;

public class BitMarketDigest implements ParamsDigest {

  public static final String HMAC_SHA_512 = "HmacSHA512";
  private ThreadLocal<Mac> threadLocalMac;

  private BitMarketDigest(String secretKeyBase64) {
    BaseParamsDigest(secretKeyBase64, HMAC_SHA_512);
  }

  public static BitMarketDigest createInstance(String secretKeyBase64) {
    return secretKeyBase64 == null ? null : new BitMarketDigest(secretKeyBase64);
  }

  public String digestParams(RestInvocation restInvocation) {
    try {
      String postBody = restInvocation.getRequestBody();
      Mac mac = getMac();
      mac.update(postBody.getBytes("UTF-8"));
      return String.format("%0128x", new BigInteger(1, mac.doFinal()));
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("Illegal encoding, check the code.", e);
    }
  }

  protected void BaseParamsDigest(String secretKeyBase64, final String hmacString) throws IllegalArgumentException {

    try {
      final SecretKey secretKey = new SecretKeySpec(secretKeyBase64.getBytes("UTF-8"), hmacString);
      threadLocalMac = new ThreadLocal<Mac>() {

        @Override
        protected Mac initialValue() {

          try {
            Mac mac = Mac.getInstance(hmacString);
            mac.init(secretKey);
            return mac;
          } catch (InvalidKeyException e) {
            throw new IllegalArgumentException("Invalid key for hmac initialization.", e);
          } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Illegal algorithm for post body digest. Check the implementation.");
          }
        }
      };
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("Illegal encoding, check the code.", e);
    }
  }

  protected Mac getMac() {
    return threadLocalMac.get();
  }
}
