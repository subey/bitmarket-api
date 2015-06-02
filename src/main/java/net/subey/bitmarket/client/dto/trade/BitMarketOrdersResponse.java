package net.subey.bitmarket.client.dto.trade;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import net.subey.bitmarket.client.dto.BitMarketResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketOrdersResponse extends BitMarketResponse<Map<String, List<BitMarketOrder>>> {

  public BitMarketOrdersResponse(@JsonProperty("success") boolean success, @JsonProperty("data") Map<String, List<BitMarketOrder>> result,
      @JsonProperty("time") Long time, @JsonProperty("limit") Map<String, BigDecimal> limit) {
    super(success, result, time, limit);
  }
}
