package net.subey.bitmarket.dto.account;

import java.math.BigDecimal;
import java.util.Map;
import net.subey.bitmarket.dto.BitMarketResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketAccountInfoResponse extends BitMarketResponse<BitMarketAccountInfo> {

  public BitMarketAccountInfoResponse(@JsonProperty("success") boolean success, @JsonProperty("data") BitMarketAccountInfo value,
      @JsonProperty("time") Long time, @JsonProperty("limit") Map<String, BigDecimal> limit) {
    super(success, value, time, limit);
  }

}
