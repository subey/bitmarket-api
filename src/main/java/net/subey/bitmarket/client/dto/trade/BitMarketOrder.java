package net.subey.bitmarket.client.dto.trade;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketOrder {
  private final Long id;
  private final String pair;
  private final BigDecimal amount;
  private final BigDecimal rate;
  private final BigDecimal fiat;
  private final Type type;
  private final Long timestamp;

  public BitMarketOrder(@JsonProperty("id") Long id, @JsonProperty("market") String pair, @JsonProperty("amount") BigDecimal amount,
      @JsonProperty("rate") BigDecimal rate, @JsonProperty("fiat") BigDecimal fiat, @JsonProperty("type") Type type,
      @JsonProperty("time") Long timestamp) {
    this.id = id;
    this.pair = pair;
    this.amount = amount;
    this.rate = rate;
    this.fiat = fiat;
    this.type = type;
    this.timestamp = timestamp;
  }

  public Long getId() {
    return id;
  }

  public String getPair() {
    return pair;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public BigDecimal getFiat() {
    return fiat;
  }

  public Type getType() {
    return type;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public static enum Type {
    buy, sell;
    public static Type formString(String name) {
      return Type.valueOf(name);
    }
  }

  @Override
  public String toString() {
    return String.format("BitMarketOrder{id=%s, pair=%s, amount=%s, rate=%s, fiat=%s, type=%s, timestamp=%s}", id, pair, amount, rate, fiat, type,
        timestamp);
  }
}
