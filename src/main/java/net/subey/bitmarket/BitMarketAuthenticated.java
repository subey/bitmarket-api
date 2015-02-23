package net.subey.bitmarket;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;
import net.subey.bitmarket.dto.account.BitMarketAccountInfoResponse;
import net.subey.bitmarket.dto.account.BitMarketHistoryResponse;
import net.subey.bitmarket.dto.trade.BitMarketCancelOrderResponse;
import net.subey.bitmarket.dto.trade.BitMarketOrder.Type;
import net.subey.bitmarket.dto.trade.BitMarketOrdersResponse;
import net.subey.bitmarket.dto.trade.BitMarketPlaceOrderResponse;
import net.subey.bitmarket.dto.trade.BitMarketTradesResponse;

@Path("/api2/")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public interface BitMarketAuthenticated extends BitMarket {
  @POST
  @FormParam("method")
  BitMarketAccountInfoResponse info(@HeaderParam("API-Key") String apiKey, @HeaderParam("API-Hash") ParamsDigest signer,
      @FormParam("tonce") SynchronizedValueFactory<Long> nonce) throws IOException, BitMarketException;

  @POST
  @FormParam("method")
  BitMarketTradesResponse trades(@HeaderParam("API-Key") String apiKey, @HeaderParam("API-Hash") ParamsDigest signer,
      @FormParam("tonce") SynchronizedValueFactory<Long> nonce, @FormParam("market") String market) throws IOException, BitMarketException;

  @POST
  @FormParam("method")
  BitMarketPlaceOrderResponse trade(@HeaderParam("API-Key") String apiKey, @HeaderParam("API-Hash") ParamsDigest signer,
      @FormParam("tonce") SynchronizedValueFactory<Long> nonce, @FormParam("market") String market, @FormParam("type") Type type,
      @FormParam("rate") BigDecimal rate, @FormParam("amount") BigDecimal amount) throws IOException, BitMarketException;

  @POST
  @FormParam("method")
  BitMarketCancelOrderResponse cancel(@HeaderParam("API-Key") String apiKey, @HeaderParam("API-Hash") ParamsDigest signer,
      @FormParam("tonce") SynchronizedValueFactory<Long> nonce, @FormParam("id") Long id) throws IOException, BitMarketException;

  @POST
  @FormParam("method")
  BitMarketOrdersResponse orders(@HeaderParam("API-Key") String apiKey, @HeaderParam("API-Hash") ParamsDigest signer,
      @FormParam("tonce") SynchronizedValueFactory<Long> nonce, @FormParam("market") String market) throws IOException, BitMarketException;

  @POST
  @FormParam("method")
  BitMarketHistoryResponse history(@HeaderParam("API-Key") String apiKey, @HeaderParam("API-Hash") ParamsDigest signer,
      @FormParam("tonce") SynchronizedValueFactory<Long> nonce, @FormParam("currency") String market, @FormParam("start") Long start,
      @FormParam("count") Long count) throws IOException, BitMarketException;

}
