package net.subey.bitmarket.client.dto.trade;

import java.math.BigDecimal;
import java.util.Map;

import net.subey.bitmarket.client.dto.BitMarketResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketTradesResponse extends BitMarketResponse<BitMarketTrades> {
  public BitMarketTradesResponse(@JsonProperty("success") boolean success, @JsonProperty("data") BitMarketTrades result,
      @JsonProperty("time") Long time, @JsonProperty("limit") Map<String, BigDecimal> limit) {
    super(success, result, time, limit);
  }

}
