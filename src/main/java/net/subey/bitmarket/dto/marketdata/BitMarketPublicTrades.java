package net.subey.bitmarket.dto.marketdata;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.subey.bitmarket.dto.marketdata.BitMarketPublicTrades.BitMarketTradesDeserializer;

@JsonDeserialize(using = BitMarketTradesDeserializer.class)
public class BitMarketPublicTrades {

  private final List<BitMarketPublicTrade> trades;

  public BitMarketPublicTrades(List<BitMarketPublicTrade> trades) {
    this.trades = trades;
  }

  public List<BitMarketPublicTrade> getTrades() {
    return trades;
  }

  @Override
  public String toString() {
    return "BitMarketPublicTrades {trades=" + trades + "}";
  }

  static class BitMarketTradesDeserializer extends JsonDeserializer<BitMarketPublicTrades> {

    @Override
    public BitMarketPublicTrades deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

      ObjectMapper mapper = new ObjectMapper();
      JsonNode node = mapper.readTree(jsonParser);
      List<BitMarketPublicTrade> trades = mapper.convertValue(node, new TypeReference<List<BitMarketPublicTrade>>() {
      });
      return new BitMarketPublicTrades(trades);
    }
  }
}
