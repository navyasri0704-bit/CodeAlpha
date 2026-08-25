import java.util.LinkedHashMap;
import java.util.Map;

public class Portfolio {
    private double balance;
    private final Map<String, Integer> holdings = new LinkedHashMap<>();
    private final Map<String, Double> averagePrices = new LinkedHashMap<>();

    public Portfolio(double balance) {
        this.balance = balance;
    }

    public boolean buy(Stock stock, int quantity) {
        if (stock == null || quantity <= 0) return false;

        double cost = stock.getPrice() * quantity;
        if (balance < cost) return false;

        String symbol = stock.getSymbol();
        int oldQuantity = holdings.getOrDefault(symbol, 0);
        double oldAverage = averagePrices.getOrDefault(symbol, 0.0);
        int newQuantity = oldQuantity + quantity;

        double newAverage = oldQuantity == 0
                ? stock.getPrice()
                : ((oldQuantity * oldAverage)
                + (quantity * stock.getPrice())) / newQuantity;

        balance -= cost;
        holdings.put(symbol, newQuantity);
        averagePrices.put(symbol, newAverage);

        return true;
    }

    public boolean sell(Stock stock, int quantity) {
        if (stock == null || quantity <= 0) return false;

        String symbol = stock.getSymbol();
        int owned = holdings.getOrDefault(symbol, 0);

        if (owned < quantity) return false;

        balance += stock.getPrice() * quantity;

        int remaining = owned - quantity;

        if (remaining == 0) {
            holdings.remove(symbol);
            averagePrices.remove(symbol);
        } else {
            holdings.put(symbol, remaining);
        }

        return true;
    }

    public double getBalance() {
        return balance;
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }

    public double getAveragePrice(String symbol) {
        return averagePrices.getOrDefault(symbol, 0.0);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setHolding(
            String symbol,
            int quantity,
            double averagePrice
    ) {
        holdings.put(symbol, quantity);
        averagePrices.put(symbol, averagePrice);
    }
}
