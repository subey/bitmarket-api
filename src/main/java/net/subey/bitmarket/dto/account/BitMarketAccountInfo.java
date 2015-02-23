package net.subey.bitmarket.dto.account;

import java.math.BigDecimal;
import java.util.Map;
import net.subey.bitmarket.dto.trade.BitMarketBalances;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketAccountInfo {

  private final BitMarketBalances balances;
  private final Map<String, BigDecimal> account;

  public BitMarketAccountInfo(@JsonProperty("balances") BitMarketBalances balances, @JsonProperty("account") Map<String, BigDecimal> account) {
    this.balances = balances;
    this.account = account;
  }

  public BitMarketBalances getBalances() {
    return balances;
  }

  public Map<String, BigDecimal> getAccount() {
    return account;
  }

  @Override
  public String toString() {
    return String.format("BitMarketAccountInfo{balances=%s, account=%s}", balances, account);
  }
}
