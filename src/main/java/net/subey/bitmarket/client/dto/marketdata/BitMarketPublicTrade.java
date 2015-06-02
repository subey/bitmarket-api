package net.subey.bitmarket.client.dto.marketdata;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketPublicTrade {
  private final String tid;
  private final BigDecimal price;
  private final BigDecimal amount;
  private final long date;
  private final String type;

  public BitMarketPublicTrade(@JsonProperty("tid") String tid, @JsonProperty("price") BigDecimal price, @JsonProperty("amount") BigDecimal amount,
      @JsonProperty("date") long date, @JsonProperty("type") String type) {

    this.tid = tid;
    this.price = price;
    this.amount = amount;
    this.date = date;
    this.type = type;
  }

  public String getTid() {
    return tid;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public long getDate() {
    return date;
  }
  
  public String getType() {
    return type;
  }

  @Override
  public String toString() {
    return "BitMarketPublicTrade{" + "tid=" + tid  + ", price=" + price + ", amount=" + amount + ", date=" + date + ", type=" + type + '}';
  }
}
