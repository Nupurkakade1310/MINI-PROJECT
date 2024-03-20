import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAppGUI extends JFrame {

    private JTextField amountField;
    private JTextArea transactionArea;
    private BankAccount bankAccount;

    public BankAppGUI(String userName, String userId) {
        super("Bank App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bankAccount = new BankAccount(userName, userId);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Welcome " + userName);
        JLabel idLabel = new JLabel("Your ID is " + userId);
        JLabel amountLabel = new JLabel("Enter amount:");

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton prevTransactionButton = new JButton("Previous Transaction");
        JButton exitButton = new JButton("Exit");

        amountField = new JTextField();
        transactionArea = new JTextArea();
        transactionArea.setEditable(false);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(amountField.getText());
                bankAccount.deposit(amount);
                updateTransaction("Deposited: " + amount);
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(amountField.getText());
                bankAccount.withdraw(amount);
                updateTransaction("Withdrew: " + amount);
            }
        });

        prevTransactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bankAccount.getPreviousTransaction();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(nameLabel);
        panel.add(idLabel);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(prevTransactionButton);
        panel.add(exitButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(transactionArea), BorderLayout.CENTER);
    }

    private void updateTransaction(String transaction) {
        transactionArea.append(transaction + "\n");
    }

    public static void main(String[] args) {
        BankAppGUI bankAppGUI = new BankAppGUI("Nupur", "18051");
        bankAppGUI.setVisible(true);
    }
}