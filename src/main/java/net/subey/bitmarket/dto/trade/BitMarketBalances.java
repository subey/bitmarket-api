package net.subey.bitmarket.dto.trade;

import java.math.BigDecimal;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketBalances {
  private final Map<String, BigDecimal> available;
  private final Map<String, BigDecimal> blocked;

  public BitMarketBalances(@JsonProperty("available") Map<String, BigDecimal> available, @JsonProperty("blocked") Map<String, BigDecimal> blocked) {
    this.available = available;
    this.blocked = blocked;
  }

  public Map<String, BigDecimal> getAvailable() {
    return available;
  }

  public Map<String, BigDecimal> getBlocked() {
    return blocked;
  }

  @Override
  public String toString() {
    return "BitMarketBalances{available=" + available + ", blocked=" + blocked + "}";
  }
}
