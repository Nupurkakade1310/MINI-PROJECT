import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingApp extends JFrame {

    private JTextField firstNameField, lastNameField, balanceField;
    private JButton createAccountButton, viewAccountButton;

    public BankingApp() {
        setTitle("Banking Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();
        JLabel balanceLabel = new JLabel("Initial Balance:");
        balanceField = new JTextField();

        createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create new account logic here
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                double balance = Double.parseDouble(balanceField.getText());
                // Add code to create account
                JOptionPane.showMessageDialog(BankingApp.this, "Account created successfully!");
            }
        });

        viewAccountButton = new JButton("View Account");
        viewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // View account details logic here
                // Placeholder for demonstration purposes
                JOptionPane.showMessageDialog(BankingApp.this, "Account Details:\n" +
                        "First Name: nupur\n" +
                        "Last Name: kakade\n" +
                        "Balance: 12000");
            }
        });

        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(balanceLabel);
        add(balanceField);
        add(createAccountButton);
        add(viewAccountButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankingApp();
            }
        });
    }
}
