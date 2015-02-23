package net.subey.bitmarket.dto;

import java.math.BigDecimal;
import java.util.Map;

import si.mazi.rescu.ExceptionalReturnContentException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketResponse<V> {
  private final boolean success;
  private final V result;
  private final Long time;
  private final Map<String, BigDecimal> limit;

  public BitMarketResponse(@JsonProperty("success") boolean success, V result, @JsonProperty("time") Long time,
      @JsonProperty("limit") Map<String, BigDecimal> limit) {

    this.success = success;
    this.result = result;
    this.time = time;
    this.limit = limit;

    if (!success) {
      throw new ExceptionalReturnContentException("Bad response");
    }
  }

  public boolean isSuccess() {
    return success;
  }

  public V getResult() {
    return result;
  }

  @Override
  public String toString() {
    return String.format("BitMarketResponse{success=%s, result=%s, limit=%s}", success, result, limit);
  }

}
