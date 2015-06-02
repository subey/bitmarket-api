package net.subey.bitmarket.client.dto.account;

import java.math.BigDecimal;
import java.util.Map;

import net.subey.bitmarket.client.dto.BitMarketResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketHistoryResponse extends BitMarketResponse<BitMarketHistory> {
  public BitMarketHistoryResponse(@JsonProperty("success") boolean success, @JsonProperty("data") BitMarketHistory result,
      @JsonProperty("time") Long time, @JsonProperty("limit") Map<String, BigDecimal> limit) {
    super(success, result, time, limit);
  }

}
