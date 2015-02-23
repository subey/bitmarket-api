package net.subey.bitmarket.dto.account;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketHistoryEntry {
  private final Long id;
  private final BigDecimal amount;
  private final String currency;
  private final Long time;
  private final BigDecimal rate;
  private final BigDecimal commission;
  private final Type type;

  public BitMarketHistoryEntry(@JsonProperty("id") Long id, @JsonProperty("amount") BigDecimal amount, @JsonProperty("currency") String currency,
      @JsonProperty("time") Long time, @JsonProperty("rate") BigDecimal rate, @JsonProperty("commission") BigDecimal commission,
      @JsonProperty("type") Type type) {
    this.id = id;
    this.amount = amount;
    this.currency = currency;
    this.time = time;
    this.rate = rate;
    this.commission = commission;
    this.type = type;
  }

  public static enum Type {
    deposit, withdraw, withdrawCancel, order, trade, cancel;
    public static Type formString(String name) {
      return Type.valueOf(name);
    }

  }

  public Long getId() {
    return id;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }

  public Long getTime() {
    return time;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public BigDecimal getCommission() {
    return commission;
  }

  public Type getType() {
    return type;
  }

  @Override
  public String toString() {
    return String.format("BitMarketHistoryEntry{id=%d, amount=%s, currency=%s, time=%d, rate=%s, commission=%s, type=%s}", id, amount, currency,
        time, rate, commission, type);
  }
}
