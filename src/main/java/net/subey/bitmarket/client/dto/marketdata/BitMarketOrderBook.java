package net.subey.bitmarket.client.dto.marketdata;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketOrderBook {
  private final List<BitMarketPublicOrder> asks;
  private final List<BitMarketPublicOrder> bids;

  public BitMarketOrderBook(@JsonProperty("asks") List<BitMarketPublicOrder> asks, @JsonProperty("bids") List<BitMarketPublicOrder> bids) {

    this.asks = asks;
    this.bids = bids;
  }

  public List<BitMarketPublicOrder> getAsks() {
    return asks;
  }

  public List<BitMarketPublicOrder> getBids() {
    return bids;
  }

  @Override
  public String toString() {
    return "BitMarketOrderBook {asks=" + asks + ", bids=" + bids + "}";
  }
}
