package net.subey.bitmarket.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketException extends RuntimeException {

  @JsonProperty("error")
  private int code;

  @JsonProperty("errorMsg")
  private String message;

  @JsonProperty("time")
  private Long time;

  public BitMarketException(@JsonProperty("errorMsg") String message) {
    super();
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public Integer getCode() {
    return code;
  }
  public Long getTime() {
    return time;
  }
}
