package net.subey.bitmarket.dto.trade;

import java.math.BigDecimal;
import net.subey.bitmarket.dto.trade.BitMarketOrder.Type;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketTradesEntry {
  private final Long id;
  private final BigDecimal amountCrypto;
  private final String currencyCrypto;
  private final BigDecimal amountFiat;
  private final String currencyFiat;
  private final Long time;
  private final BigDecimal rate;
  private final Type type;

  public BitMarketTradesEntry(@JsonProperty("id") Long id, @JsonProperty("amountCrypto") BigDecimal amountCrypto,
      @JsonProperty("currencyCrypto") String currencyCrypto, @JsonProperty("amountFiat") BigDecimal amountFiat,
      @JsonProperty("currencyFiat") String currencyFiat, @JsonProperty("time") Long time, @JsonProperty("rate") BigDecimal rate,
      @JsonProperty("type") Type type) {
    this.id = id;
    this.amountCrypto = amountCrypto;
    this.currencyCrypto = currencyCrypto;
    this.amountFiat = amountFiat;
    this.currencyFiat = currencyFiat;
    this.time = time;
    this.rate = rate;
    this.type = type;
  }

  public Long getId() {
    return id;
  }

  public BigDecimal getAmountCrypto() {
    return amountCrypto;
  }

  public String getCurrencyCrypto() {
    return currencyCrypto;
  }

  public BigDecimal getAmountFiat() {
    return amountFiat;
  }

  public String getCurrencyFiat() {
    return currencyFiat;
  }

  public Long getTime() {
    return time;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public Type getType() {
    return type;
  }

  @Override
  public String toString() {
    return String.format(
        "BitMarketTradesEntry{id=%s, amountCrypto=%s, currencyCrypto=%s, amountFiat=%s, currencyFiat=%s, time=%s, rate=%s, type=%s}", id,
        amountCrypto, currencyCrypto, amountFiat, currencyFiat, time, rate, type);
  }
}
