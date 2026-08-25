import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class PortfolioPanel extends JPanel {

    private final User user;
    private final Market market;
    private final DefaultTableModel model;

    public PortfolioPanel(
            User user,
            Market market
    ) {

        this.user = user;
        this.market = market;

        setLayout(
                new BorderLayout()
        );

        model =
                new DefaultTableModel(
                        new String[]{
                                "Stock",
                                "Quantity",
                                "Current Price",
                                "Value",
                                "Profit / Loss"
                        },
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {
                        return false;
                    }
                };

        add(
                new JScrollPane(
                        new JTable(model)
                ),
                BorderLayout.CENTER
        );

        JButton refresh =
                new JButton(
                        "REFRESH PORTFOLIO"
                );

        refresh.addActionListener(
                e -> refresh()
        );

        add(
                refresh,
                BorderLayout.SOUTH
        );

        refresh();
    }

    public void refresh() {

        model.setRowCount(0);

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

            double current =
                    stock.getPrice();

            double value =
                    current * quantity;

            double profit =
                    (
                            current
                                    - user.getPortfolio()
                                    .getAveragePrice(
                                            stock.getSymbol()
                                    )
                    ) * quantity;

            model.addRow(
                    new Object[]{
                            stock.getSymbol(),
                            quantity,
                            String.format(
                                    "₹ %.2f",
                                    current
                            ),
                            String.format(
                                    "₹ %.2f",
                                    value
                            ),
                            String.format(
                                    "₹ %.2f",
                                    profit
                            )
                    }
            );
        }
    }
}
