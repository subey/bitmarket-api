package net.subey.bitmarket.client;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.subey.bitmarket.client.dto.marketdata.BitMarketOrderBook;
import net.subey.bitmarket.client.dto.marketdata.BitMarketPublicTrades;
import net.subey.bitmarket.client.dto.marketdata.BitMarketTicker;

@Path("/json")
@Produces(MediaType.APPLICATION_JSON)
public interface BitMarket {
  @GET
  @Path("{currencyPair}/ticker.json")
  public BitMarketTicker getTicker(@PathParam("currencyPair") String currency) throws IOException;

  @GET
  @Path("{currencyPair}/orderbook.json")
  public BitMarketOrderBook getOrderBook(@PathParam("currencyPair") String currency) throws IOException;

  @GET
  @Path("{currencyPair}/trades.json")
  public BitMarketPublicTrades getTrades(@PathParam("currencyPair") String currency) throws IOException;
}
