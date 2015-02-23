package net.subey.bitmarket.service;

import java.util.Calendar;
import si.mazi.rescu.SynchronizedValueFactory;

public class TimestampIncrementingNonceFactory implements SynchronizedValueFactory<Long> {

  private long lastNonce = 0;

  public Long createValue() {
    Calendar calendar = Calendar.getInstance();
    lastNonce = calendar.getTimeInMillis() / 1000;
    return (long) lastNonce;
  }
}
