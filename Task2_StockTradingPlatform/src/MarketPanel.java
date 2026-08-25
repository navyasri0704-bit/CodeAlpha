import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MarketPanel extends JPanel {

    private final Market market;
    private final DashboardFrame dashboard;
    private final JTable table;

    public MarketPanel(
            Market market,
            DashboardFrame dashboard
    ) {

        this.market = market;
        this.dashboard = dashboard;

        setLayout(
                new BorderLayout()
        );

        DefaultTableModel model =
                new DefaultTableModel(
                        new String[]{
                                "Symbol",
                                "Company",
                                "Price"
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

        for (Stock stock : market.getStocks()) {

            model.addRow(
                    new Object[]{
                            stock.getSymbol(),
                            stock.getCompanyName(),
                            String.format(
                                    "₹ %.2f",
                                    stock.getPrice()
                            )
                    }
            );
        }

        table = new JTable(model);

        add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        JButton buyButton =
                new JButton("BUY STOCK");

        JButton sellButton =
                new JButton("SELL STOCK");

        buyButton.addActionListener(
                e -> trade(true)
        );

        sellButton.addActionListener(
                e -> trade(false)
        );

        JPanel buttons = new JPanel();

        buttons.add(buyButton);
        buttons.add(sellButton);

        add(
                buttons,
                BorderLayout.SOUTH
        );
    }

    private Stock getSelectedStock() {

        int row =
                table.getSelectedRow();

        if (row < 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a stock first."
            );

            return null;
        }

        return market.getStock(
                table.getValueAt(row, 0)
                        .toString()
        );
    }

    private void trade(boolean buying) {

        Stock stock =
                getSelectedStock();

        if (stock == null) {
            return;
        }

        String input =
                JOptionPane.showInputDialog(
                        this,
                        "Enter quantity:"
                );

        if (input == null) {
            return;
        }

        try {

            int quantity =
                    Integer.parseInt(input);

            if (quantity <= 0) {
                throw new NumberFormatException();
            }

            if (buying) {
                dashboard.buyStock(
                        stock,
                        quantity
                );
            } else {
                dashboard.sellStock(
                        stock,
                        quantity
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter a valid positive quantity."
            );
        }
    }
}
