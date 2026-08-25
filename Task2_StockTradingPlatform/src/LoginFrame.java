import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private final JTextField usernameField =
            new JTextField();

    private final JPasswordField passwordField =
            new JPasswordField();

    public LoginFrame() {

        setTitle(
                "Stock Trading Platform - Login"
        );

        setSize(450, 350);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createUI();

        setVisible(true);
    }

    private void createUI() {

        JPanel panel = new JPanel();

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        50,
                        30,
                        50
                )
        );

        JLabel title =
                new JLabel(
                        "STOCK TRADING PLATFORM"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panel.add(title);

        panel.add(
                Box.createVerticalStrut(30)
        );

        JLabel userLabel =
                new JLabel("Username");

        userLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panel.add(userLabel);

        usernameField.setMaximumSize(
                new Dimension(300, 35)
        );

        panel.add(usernameField);

        panel.add(
                Box.createVerticalStrut(15)
        );

        JLabel passwordLabel =
                new JLabel("Password");

        passwordLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panel.add(passwordLabel);

        passwordField.setMaximumSize(
                new Dimension(300, 35)
        );

        panel.add(passwordField);

        panel.add(
                Box.createVerticalStrut(25)
        );

        JButton loginButton =
                new JButton("LOGIN");

        loginButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        loginButton.addActionListener(
                e -> login()
        );

        panel.add(loginButton);

        add(panel);
    }

    private void login() {

        String username =
                usernameField.getText().trim();

        String password =
                new String(
                        passwordField.getPassword()
                );

        if (
                username.isEmpty()
                        || password.isEmpty()
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter username and password."
            );

            return;
        }

        User user =
                new User(username);

        FileManager.load(user);

        new DashboardFrame(user);

        dispose();
    }
}
 
    

