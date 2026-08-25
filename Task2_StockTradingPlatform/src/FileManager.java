import java.io.*;

public class FileManager {
    private static final File FILE =
            new File("data/portfolio.txt");

    public static void save(User user) {
        try {
            File parent = FILE.getParentFile();

            if (parent != null) {
                parent.mkdirs();
            }

            try (PrintWriter writer =
                         new PrintWriter(new FileWriter(FILE))) {

                Portfolio portfolio =
                        user.getPortfolio();

                writer.println(
                        "BALANCE=" + portfolio.getBalance()
                );

                for (String symbol :
                        portfolio.getHoldings().keySet()) {

                    writer.println(
                            symbol + ","
                                    + portfolio.getHoldings()
                                    .get(symbol)
                                    + ","
                                    + portfolio.getAveragePrice(symbol)
                    );
                }
            }

        } catch (IOException e) {
            System.out.println(
                    "Could not save portfolio: "
                            + e.getMessage()
            );
        }
    }

    public static void load(User user) {
        if (!FILE.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.startsWith("BALANCE=")) {

                    user.getPortfolio().setBalance(
                            Double.parseDouble(
                                    line.substring(8)
                            )
                    );

                } else {

                    String[] parts = line.split(",");

                    if (parts.length == 3) {

                        user.getPortfolio().setHolding(
                                parts[0],
                                Integer.parseInt(parts[1]),
                                Double.parseDouble(parts[2])
                        );
                    }
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(
                    "Could not load portfolio: "
                            + e.getMessage()
            );
        }
    }
}
