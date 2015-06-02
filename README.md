# bitmarket-api
Bitmarket API client for Java

Install via gradle:
-----
```gradle
repositories {
    ...
    maven { url 'http://maven.subey.net' }
}

dependencies {
    ...
    compile 'net.subey.bitmarket:client:0.0.4-SNAPSHOT'
}
```

Usage:
-----
```java
public class App {

  private static String ACCESS_KEY = "YOUR_ACCESS_KEY";
  private static String SECRET_KEY = "YOUR_SECRET_KEY";

  private TimestampIncrementingNonceFactory nonceFactory = new TimestampIncrementingNonceFactory();
  private BitMarket bitMarket = RestProxyFactory.createProxy(BitMarket.class, "https://www.bitmarket.pl");
  private BitMarketAuthenticated bitMarketAuth = RestProxyFactory.createProxy(BitMarketAuthenticated.class, "https://www.bitmarket.pl");
  protected ParamsDigest signature = BitMarketDigest.createInstance(SECRET_KEY);

  public static void main(String[] args) {
    App main = new App();
    main.test();
  }

  public void test() {
    // params
    String market = "BTCPLN";
    String currency = "BTC";
    Long start = null;
    Long count = null;
    BigDecimal rate = new BigDecimal(1500);
    BigDecimal amount = new BigDecimal(0.01);
    
    try {
 
      // PUBLIC API

      // ticker
      BitMarketTicker ticker = bitMarket.getTicker(market);
      System.out.println(ticker.toString());
      
      // orderbook
      BitMarketOrderBook orderbook = bitMarket.getOrderBook(market);
      System.out.println(orderbook.toString());
      
      // trades
      BitMarketPublicTrades publicTrades = bitMarket.getTrades(market);
      System.out.println(publicTrades.toString());
      

      // PRIVATE API
      
      // info - account information
      BitMarketAccountInfoResponse info = bitMarketAuth.info(ACCESS_KEY, signature, nonceFactory);
      System.out.println(info.toString());

      // history - account operation history    
      BitMarketHistoryResponse history = bitMarketAuth.history(ACCESS_KEY, signature, nonceFactory, currency, start, count);
      System.out.println(history.toString());

      // trades - list of user trades
      BitMarketTradesResponse trades = bitMarketAuth.trades(ACCESS_KEY, signature, nonceFactory, market);
      System.out.println(trades.toString());

      // orders - list of user orders
      BitMarketOrdersResponse orders = bitMarketAuth.orders(ACCESS_KEY, signature, nonceFactory, market);
      System.out.println(orders.toString());
       
      // trade - submit an order
      BitMarketPlaceOrderResponse trade = bitMarketAuth.trade(ACCESS_KEY, signature, nonceFactory, market, Type.sell, rate, amount);
      System.out.println(trade.toString());

      // cancel - order cancel
      Long orderId = trade.getResult().getId();
      BitMarketCancelOrderResponse cancel = bitMarketAuth.cancel(ACCESS_KEY, signature, nonceFactory, orderId);
      System.out.println(cancel.toString());

    } catch (BitMarketException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
}

```