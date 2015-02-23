package net.subey.bitmarket.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketCancelOrder {
  private final BitMarketBalances balances;

  public BitMarketCancelOrder(@JsonProperty("balances") BitMarketBalances balances) {
    this.balances = balances;
  }

  @Override
  public String toString() {
    return String.format("BitMarketCancelOrder{balances=%s}", balances);
  }
}
