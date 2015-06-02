package net.subey.bitmarket.client.dto.marketdata;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import net.subey.bitmarket.client.dto.marketdata.BitMarketOrderBook;
import net.subey.bitmarket.client.dto.marketdata.BitMarketPublicOrder;
import net.subey.bitmarket.client.dto.marketdata.BitMarketPublicTrade;
import net.subey.bitmarket.client.dto.marketdata.BitMarketPublicTrades;
import net.subey.bitmarket.client.dto.marketdata.BitMarketTicker;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MarketdataTest {

  @Test
  public void ticker() throws IOException {

    InputStream is = MarketdataTest.class.getResourceAsStream("/marketdata/example-ticker-response.json");

    ObjectMapper mapper = new ObjectMapper();
    BitMarketTicker ticker = mapper.readValue(is, BitMarketTicker.class);

    assertThat(ticker.getBid()).isEqualTo("869.01");
    assertThat(ticker.getVolume()).isEqualTo("443.25723406");

  }

  @Test
  public void orderbook() throws IOException {

    InputStream is = MarketdataTest.class.getResourceAsStream("/marketdata/example-orderbook-response.json");

    ObjectMapper mapper = new ObjectMapper();
    BitMarketOrderBook result = mapper.readValue(is, BitMarketOrderBook.class);
    List<BitMarketPublicOrder> asks = result.getAsks();
    BitMarketPublicOrder firstEntry = asks.iterator().next();

    assertThat(firstEntry.getPrice()).isEqualTo("906.5799");
    assertThat(firstEntry.getAmount()).isEqualTo("0.731");

  }

  @Test
  public void trades() throws IOException {

    InputStream is = MarketdataTest.class.getResourceAsStream("/marketdata/example-trades-response.json");

    ObjectMapper mapper = new ObjectMapper();
    BitMarketPublicTrades result = mapper.readValue(is, BitMarketPublicTrades.class);
    List<BitMarketPublicTrade> trades = result.getTrades();

    BitMarketPublicTrade firstEntry = trades.iterator().next();

    assertThat(firstEntry.getPrice()).isEqualTo("853.0100");
    assertThat(firstEntry.getAmount()).isEqualTo("0.10006030");
    assertThat(firstEntry.getTid()).isEqualTo("397406");
    assertThat(firstEntry.getType()).isEqualTo("ask");


  }

}
