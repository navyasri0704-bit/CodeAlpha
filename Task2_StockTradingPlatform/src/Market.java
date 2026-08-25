import java.util.Arrays;
import java.util.List;

public class Market {
    private final List<Stock> stocks = Arrays.asList(
            new Stock("AAPL", "Apple", 195.00),
            new Stock("GOOGL", "Google", 175.00),
            new Stock("TSLA", "Tesla", 250.00),
            new Stock("AMZN", "Amazon", 180.00),
            new Stock("MSFT", "Microsoft", 420.00)
    );

    public List<Stock> getStocks() {
        return stocks;
    }

    public Stock getStock(String symbol) {
        for (Stock stock : stocks) {
            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }

        return null;
    }
}
 
    

