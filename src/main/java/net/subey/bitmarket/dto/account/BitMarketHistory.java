package net.subey.bitmarket.dto.account;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketHistory {
  private final Long total;
  private final Long start;
  private final Long count;
  private final List<BitMarketHistoryEntry> results;

  public BitMarketHistory(@JsonProperty("total") Long total, @JsonProperty("start") Long start, @JsonProperty("count") Long count,
      @JsonProperty("results") List<BitMarketHistoryEntry> results) {
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

  public List<BitMarketHistoryEntry> getResults() {
    return results;
  }

  @Override
  public String toString() {
    return String.format("BitMarketHistory{total=%d, start=%d, count=%d, results=%s}", total, start, count, results);
  }
}
