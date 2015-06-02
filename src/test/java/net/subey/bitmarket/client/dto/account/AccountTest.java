package net.subey.bitmarket.client.dto.account;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.io.IOException;
import java.util.List;

import net.subey.bitmarket.client.TestHelper;
import net.subey.bitmarket.client.dto.account.BitMarketAccountInfo;
import net.subey.bitmarket.client.dto.account.BitMarketAccountInfoResponse;
import net.subey.bitmarket.client.dto.account.BitMarketHistory;
import net.subey.bitmarket.client.dto.account.BitMarketHistoryEntry;
import net.subey.bitmarket.client.dto.account.BitMarketHistoryResponse;
import net.subey.bitmarket.client.dto.trade.BitMarketBalances;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

  @Test
  public void info() throws IOException {

    BitMarketAccountInfoResponse response = TestHelper.getResult("/account/example-info-response.json", BitMarketAccountInfoResponse.class);
    BitMarketAccountInfo result = response.getResult();

    BitMarketBalances balances = result.getBalances();
    assertThat(balances.getAvailable().keySet()).contains("PLN", "BTC");
    assertThat(balances.getAvailable().get("PLN")).isEqualTo("614.00003000");
    assertThat(balances.getAvailable().get("BTC")).isEqualTo("0.58910000");
    assertThat(balances.getBlocked().keySet()).contains("PLN", "BTC");
  }

  @Test
  public void history() throws IOException {

    BitMarketHistoryResponse response = TestHelper.getResult("/account/example-history-response.json", BitMarketHistoryResponse.class);
    BitMarketHistory history = response.getResult();

    Assert.assertThat(response.isSuccess(), is(true));

    List<BitMarketHistoryEntry> historyResults = history.getResults();
    BitMarketHistoryEntry firstEntry = historyResults.iterator().next();
    Assert.assertThat(firstEntry.getType(), is(BitMarketHistoryEntry.Type.order));
    Assert.assertThat(firstEntry.getId(), is(6916537L));
    Assert.assertThat(firstEntry.getCurrency(), is("BTC"));

  }
}
