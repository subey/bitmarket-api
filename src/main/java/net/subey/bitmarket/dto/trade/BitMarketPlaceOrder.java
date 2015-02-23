package net.subey.bitmarket.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketPlaceOrder {

  private final Long id;
  private final BitMarketOrder order;
  private final BitMarketBalances balances;

  public BitMarketPlaceOrder(@JsonProperty("id") Long id, @JsonProperty("order") BitMarketOrder order,
      @JsonProperty("balances") BitMarketBalances balances) {
    this.id = id;
    this.order = order;
    this.balances = balances;
  }

  public Long getId() {
    return id;
  }

  public BitMarketOrder getOrder() {
    return order;
  }

  public BitMarketBalances getBalances() {
    return balances;
  }

  @Override
  public String toString() {
    return String.format("BitMarketPlaceOrder{id=%s, order=%s, balances=%s}", id, order, balances);
  }
}
