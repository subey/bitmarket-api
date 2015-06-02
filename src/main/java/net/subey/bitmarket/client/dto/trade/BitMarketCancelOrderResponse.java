package net.subey.bitmarket.client.dto.trade;

import java.math.BigDecimal;
import java.util.Map;

import net.subey.bitmarket.client.dto.BitMarketResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketCancelOrderResponse extends BitMarketResponse<BitMarketCancelOrder> {

  public BitMarketCancelOrderResponse(@JsonProperty("success") boolean success, @JsonProperty("data") BitMarketCancelOrder result,
      @JsonProperty("time") Long time, @JsonProperty("limit") Map<String, BigDecimal> limit) {
    super(success, result, time, limit);
  }
}
