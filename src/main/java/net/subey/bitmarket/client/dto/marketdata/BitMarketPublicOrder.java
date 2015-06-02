package net.subey.bitmarket.client.dto.marketdata;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import net.subey.bitmarket.client.dto.marketdata.BitMarketPublicOrder.BitMarketPublicOrderDeserializer;

@JsonDeserialize(using = BitMarketPublicOrderDeserializer.class)
public class BitMarketPublicOrder {
  private final BigDecimal price;
  private final BigDecimal amount;

  public BitMarketPublicOrder(BigDecimal price, BigDecimal amount) {
    this.price = price;
    this.amount = amount;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "BitMarketPublicOrder {amount=" + amount + ", price=" + price + "}";
  }

  static class BitMarketPublicOrderDeserializer extends JsonDeserializer<BitMarketPublicOrder> {

    @Override
    public BitMarketPublicOrder deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

      final ObjectCodec oc = jp.getCodec();
      final JsonNode node = oc.readTree(jp);
      final String priceString = node.path(0).asText();
      final String amountString = node.path(1).asText();

      return new BitMarketPublicOrder(new BigDecimal(priceString), new BigDecimal(amountString));
    }
  }
}
