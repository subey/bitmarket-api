package net.subey.bitmarket.dto.trade;

import java.math.BigDecimal;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.subey.bitmarket.dto.BitMarketResponse;

public class BitMarketPlaceOrderResponse extends BitMarketResponse<BitMarketPlaceOrder> {

  public BitMarketPlaceOrderResponse(@JsonProperty("success") boolean success, @JsonProperty("data") BitMarketPlaceOrder result,
      @JsonProperty("time") Long time, @JsonProperty("limit") Map<String, BigDecimal> limit) {
    super(success, result, time, limit);
  }

}
