package net.subey.bitmarket.client.dto.trade;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.io.IOException;
import java.util.List;
import java.util.Map;





import net.subey.bitmarket.client.TestHelper;
import net.subey.bitmarket.client.dto.trade.BitMarketOrder.Type;

import org.junit.Assert;
import org.junit.Test;

public class TradeTest {

  @Test
  public void trades() throws IOException {

    BitMarketTradesResponse response = TestHelper.getResult("/trade/example-trades-response.json", BitMarketTradesResponse.class);
    BitMarketTrades result = response.getResult();

    Assert.assertThat(response.isSuccess(), is(true));
    List<BitMarketTradesEntry> entries = result.getResults();

    BitMarketTradesEntry firstEntry = entries.iterator().next();
    Assert.assertThat(firstEntry.getType(), is(Type.buy));
    Assert.assertThat(firstEntry.getId(), is(275879L));
    Assert.assertThat(firstEntry.getCurrencyFiat(), is("PLN"));
    assertThat(firstEntry.getAmountFiat()).isEqualTo("330.29997000");
  }

  @Test
  public void orders() throws IOException {

    BitMarketOrdersResponse response = TestHelper.getResult("/trade/example-open-orders-response.json", BitMarketOrdersResponse.class);

    Assert.assertThat(response.isSuccess(), is(true));
    Map<String, List<BitMarketOrder>> result = response.getResult();

    BitMarketOrder firstEntry = result.get("sell").iterator().next();
    Assert.assertThat(firstEntry.getType(), is(Type.sell));
    Assert.assertThat(firstEntry.getId(), is(4262868L));
    Assert.assertThat(firstEntry.getPair(), is("BTCPLN"));

  }

  @Test
  public void trade() throws IOException {

    BitMarketPlaceOrderResponse response = TestHelper.getResult("/trade/example-trade-response.json", BitMarketPlaceOrderResponse.class);

    Assert.assertThat(response.isSuccess(), is(true));
    BitMarketPlaceOrder result = response.getResult();

    BitMarketBalances balances = result.getBalances();
    assertThat(balances.getAvailable().keySet()).contains("PLN", "BTC");
    assertThat(balances.getAvailable().get("PLN")).isEqualTo("614.00003000");
    assertThat(balances.getAvailable().get("EUR")).isEqualTo("0.00000000");

    BitMarketOrder order = result.getOrder();
    Assert.assertThat(order.getId(), is(4259434L));
    Assert.assertThat(order.getPair(), is("BTCPLN"));
    Assert.assertThat(order.getType(), is(Type.sell));

  }

  @Test
  public void cancel() throws IOException {

  }

}
