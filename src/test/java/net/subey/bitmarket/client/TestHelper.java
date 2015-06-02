package net.subey.bitmarket.client;

import java.io.IOException;
import java.io.InputStream;

import net.subey.bitmarket.client.dto.BitMarketResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestHelper {
  public static <RC extends BitMarketResponse> RC getResult(String file, Class<RC> resultClass) throws IOException {

    InputStream is = TestHelper.class.getResourceAsStream(file);
    return new ObjectMapper().readValue(is, resultClass);
  }
}
