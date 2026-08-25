import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TransactionPanel extends JPanel {

    private final DefaultTableModel model;

    public TransactionPanel(
            List<Transaction> transactions
    ) {

        setLayout(
                new BorderLayout()
        );

        model =
                new DefaultTableModel(
                        new String[]{
                                "Type",
                                "Stock",
                                "Quantity",
                                "Price",
                                "Date"
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

        for (
                Transaction transaction :
                transactions
        ) {

            addTransaction(transaction);
        }
    }

    public void addTransaction(
            Transaction transaction
    ) {

        model.addRow(
                new Object[]{
                        transaction.getType(),
                        transaction.getSymbol(),
                        transaction.getQuantity(),
                        String.format(
                                "₹ %.2f",
                                transaction.getPrice()
                        ),
                        transaction.getDate()
                }
        );
    }
}
