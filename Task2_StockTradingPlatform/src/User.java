public class User {
    private final String username;
    private final Portfolio portfolio;

    public User(String username) {
        this.username = username;
        this.portfolio = new Portfolio(100000.0);
    }

    public String getUsername() {
        return username;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
}
