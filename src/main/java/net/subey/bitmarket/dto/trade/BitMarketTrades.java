package net.subey.bitmarket.dto.trade;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketTrades {
  private final Long total;
  private final Long start;
  private final Long count;
  private final List<BitMarketTradesEntry> results;

  public BitMarketTrades(@JsonProperty("total") Long total, @JsonProperty("start") Long start, @JsonProperty("count") Long count,
      @JsonProperty("results") List<BitMarketTradesEntry> results) {
    this.total = total;
    this.start = start;
    this.count = count;
    this.results = results;
  }

  public Long getTotal() {
    return total;
  }

  public Long getStart() {
    return start;
  }

  public Long getCount() {
    return count;
  }

  public List<BitMarketTradesEntry> getResults() {
    return results;
  }

  @Override
  public String toString() {
    return String.format("BitMarketTrades{total=%d, start=%d, count=%d, results=%s}", total, start, count, results);
  }
}
