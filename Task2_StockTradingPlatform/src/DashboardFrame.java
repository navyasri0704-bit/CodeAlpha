import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DashboardFrame extends JFrame {

    private final User user;
    private final Market market =
            new Market();

    private final List<Transaction> transactions =
            new ArrayList<>();

    private JLabel balanceLabel;
    private JLabel portfolioValueLabel;
    private JLabel profitLabel;

    private PortfolioPanel portfolioPanel;
    private TransactionPanel transactionPanel;

    public DashboardFrame(User user) {

        this.user = user;

        setTitle(
                "Stock Trading Platform"
        );

        setSize(1100, 700);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createUI();

        updateDashboard();

        setVisible(true);
    }

    private void createUI() {

        setLayout(
                new BorderLayout()
        );

        JLabel title =
                new JLabel(
                        "STOCK TRADING PLATFORM - Welcome, "
                                + user.getUsername()
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        title.setBorder(
                BorderFactory.createEmptyBorder(
                        15,
                        20,
                        15,
                        20
                )
        );

        add(
                title,
                BorderLayout.NORTH
        );

        JTabbedPane tabs =
                new JTabbedPane();

        tabs.addTab(
                "Dashboard",
                dashboardPanel()
        );

        tabs.addTab(
                "Market",
                new MarketPanel(
                        market,
                        this
                )
        );

        portfolioPanel =
                new PortfolioPanel(
                        user,
                        market
                );

        tabs.addTab(
                "Portfolio",
                portfolioPanel
        );

        transactionPanel =
                new TransactionPanel(
                        transactions
                );

        tabs.addTab(
                "Transactions",
                transactionPanel
        );

        add(
                tabs,
                BorderLayout.CENTER
        );
    }

    private JPanel dashboardPanel() {

        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );

        JPanel cards =
                new JPanel(
                        new GridLayout(
                                1,
                                3,
                                20,
                                20
                        )
                );

        cards.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        30,
                        30,
                        30
                )
        );

        balanceLabel =
                new JLabel();

        portfolioValueLabel =
                new JLabel();

        profitLabel =
                new JLabel();

        cards.add(
                card(
                        "AVAILABLE BALANCE",
                        balanceLabel
                )
        );

        cards.add(
                card(
                        "PORTFOLIO VALUE",
                        portfolioValueLabel
                )
        );

        cards.add(
                card(
                        "PROFIT / LOSS",
                        profitLabel
                )
        );

        panel.add(
                cards,
                BorderLayout.NORTH
        );

        JLabel message =
                new JLabel(
                        "<html><center>"
                                + "<h1>Welcome!</h1>"
                                + "<p>Use the Market tab to buy and sell stocks.</p>"
                                + "<p>Use Portfolio to track your performance.</p>"
                                + "</center></html>",
                        SwingConstants.CENTER
                );

        panel.add(
                message,
                BorderLayout.CENTER
        );

        return panel;
    }

    private JPanel card(
            String title,
            JLabel value
    ) {

        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );

        panel.setBorder(
                BorderFactory.createLineBorder(
                        Color.GRAY,
                        2
                )
        );

        JLabel label =
                new JLabel(
                        title,
                        SwingConstants.CENTER
                );

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        value.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        value.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        panel.add(
                label,
                BorderLayout.NORTH
        );

        panel.add(
                value,
                BorderLayout.CENTER
        );

        return panel;
    }

    public void buyStock(
            Stock stock,
            int quantity
    ) {

        if (
                !user.getPortfolio()
                        .buy(
                                stock,
                                quantity
                        )
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Insufficient balance."
            );

            return;
        }

        Transaction transaction =
                new Transaction(
                        "BUY",
                        stock.getSymbol(),
                        quantity,
                        stock.getPrice()
                );

        transactions.add(transaction);

        transactionPanel.addTransaction(
                transaction
        );

        FileManager.save(user);

        updateDashboard();

        portfolioPanel.refresh();

        JOptionPane.showMessageDialog(
                this,
                "Stock purchased successfully!"
        );
    }

    public void sellStock(
            Stock stock,
            int quantity
    ) {

        if (
                !user.getPortfolio()
                        .sell(
                                stock,
                                quantity
                        )
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "You do not own enough stocks."
            );

            return;
        }

        Transaction transaction =
                new Transaction(
                        "SELL",
                        stock.getSymbol(),
                        quantity,
                        stock.getPrice()
                );

        transactions.add(transaction);

        transactionPanel.addTransaction(
                transaction
        );

        FileManager.save(user);

        updateDashboard();

        portfolioPanel.refresh();

        JOptionPane.showMessageDialog(
                this,
                "Stock sold successfully!"
        );
    }

    private void updateDashboard() {

        double value = 0;
        double profit = 0;

        for (
                Map.Entry<String, Integer> entry :
                user.getPortfolio()
                        .getHoldings()
                        .entrySet()
        ) {

            Stock stock =
                    market.getStock(
                            entry.getKey()
                    );

            int quantity =
                    entry.getValue();

            value +=
                    stock.getPrice()
                            * quantity;

            profit +=
                    (
                            stock.getPrice()
                                    - user.getPortfolio()
                                    .getAveragePrice(
                                            stock.getSymbol()
                                    )
                    ) * quantity;
        }

        balanceLabel.setText(
                String.format(
                        "₹ %.2f",
                        user.getPortfolio()
                                .getBalance()
                )
        );

        portfolioValueLabel.setText(
                String.format(
                        "₹ %.2f",
                        value
                )
        );

        profitLabel.setText(
                String.format(
                        "₹ %.2f",
                        profit
                )
        );
    }
}
