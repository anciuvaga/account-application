import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Bank UI using Java Swing
 */
public class BankUI extends JFrame implements ActionListener{

    // Components:
    // buttons: withdraw, deposit, calculate interest, apply interest
    //exit, create account
    // lables: account number, balance, amount (withdraw and deposit)
    // text fields: account number, amount.

    //Buttons
    private JButton btnTransaction;
    private JButton btnCalcInterest;
    private JButton btnApplyInterest;
    private JButton btnExit;
    private JButton btnCreate;
    private JButton btnBalance;

    //Labels
    private JLabel lblAccountNumber;
    private JLabel lblBalance;
    private JLabel lblAmount;
    private JLabel lblMessage; //convey message to user

    //Text Fields
    private JTextField txtAccountNumber;
    private JTextField txtAmount;
    private JTextField txtBalance;

    //Transaction buttons
    private JRadioButton radWithdraw;
    private JRadioButton radDeposit;

    //Account Create Buttons
    private JRadioButton radChecking;
    private JRadioButton radSavings;

    //button Group
    private ButtonGroup transGroup;
    private ButtonGroup accountGroup;

    //JPanels
    private JPanel inputPanel;
    private JPanel commandPanel;

    private Bank bank;


    public BankUI() {

        this.bank = new Bank();
        this.setTitle("Bank Account UI");
        this.setSize(600, 340);
        this.setPreferredSize(new Dimension(600, 340));
        this.setLocation(200, 300);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5 ,5));
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Setup Frame Features

        //Setup Inputs
        setupInputs();

        //Setup commands
        setupCommands();

        //pack UI
        pack();
    }

    private void setupInputs() {
        // JPanel
        this.inputPanel = new JPanel();
        this.inputPanel.setPreferredSize(new Dimension(560, 150));
        this.inputPanel.setBorder(BorderFactory.createTitledBorder("Inputs"));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        top.setPreferredSize(new Dimension(540, 40));
        this.inputPanel.add(top);

        //Account Number
        this.lblAccountNumber = new JLabel("Account Number");
        this.lblAccountNumber.setPreferredSize(new Dimension(120, 30));
        this.inputPanel.add(this.lblAccountNumber);

        this.txtAccountNumber = new JTextField();
        this.txtAccountNumber.setPreferredSize(new Dimension(130, 30));
        this.inputPanel.add(this.txtAccountNumber);

        //Account Number
        this.lblBalance = new JLabel("Account Balance");
        this.lblBalance.setPreferredSize(new Dimension(120, 30));
        this.inputPanel.add(this.lblBalance);

        this.txtBalance = new JTextField();
        this.txtBalance.setEditable(false);
        this.txtBalance.setPreferredSize(new Dimension(130, 30));
        this.inputPanel.add(this.txtBalance);


        //two radio buttons for withdraw / deposit
        this.radWithdraw = new JRadioButton("Withdraw");
        this.radWithdraw.setPreferredSize(new Dimension(120, 30));
        this.inputPanel.add(this.radWithdraw);
        this.radWithdraw.setSelected(true);

        this.radDeposit = new JRadioButton("Deposit");
        this.radDeposit.setPreferredSize(new Dimension(130,30));
        this.inputPanel.add(this.radDeposit);

        //Transaction Amount
        this.lblAmount = new JLabel("Transaction Amount");
        this.lblAmount.setPreferredSize(new Dimension(120, 30));
        this.inputPanel.add(this.lblAmount);

        this.txtAmount = new JTextField();
        this.txtAmount.setPreferredSize(new Dimension(130, 30));
        this.inputPanel.add(this.txtAmount);

        JLabel lblType = new JLabel("Select Account Type");
        top.add(lblType);

        // two buttons for Account type
        this.radChecking = new JRadioButton("Checking");
        this.radChecking.setPreferredSize(new Dimension(120, 30));
        top.add(this.radChecking);
        this.radChecking.setSelected(true);

        this.radSavings = new JRadioButton("Savings");
        this.radSavings.setPreferredSize(new Dimension(130,30));
        top.add(this.radSavings);

        this.accountGroup = new ButtonGroup();
        this.accountGroup.add(this.radChecking);
        this.accountGroup.add(this.radSavings);

        this.transGroup = new ButtonGroup();
        this.transGroup.add(this.radWithdraw);
        this.transGroup.add(this.radDeposit);

        //add to frame
        this.add(this.inputPanel);
    }

    /**
     * Add Command Buttons to the UI
     */
    private void setupCommands() {
        // JPanel
        this.commandPanel = new JPanel();
        this.commandPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10, 20));
        this.commandPanel.setPreferredSize(new Dimension(560, 120));
        this.commandPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Create button
        this.btnCreate = new JButton("Create");
        this.btnCreate.setPreferredSize(new Dimension(140, 30));
        this.btnCreate.addActionListener(this);
        this.commandPanel.add(this.btnCreate);

        // Balance button
        this.btnBalance = new JButton("Balance");
        this.btnBalance.setPreferredSize(new Dimension(140, 30));
        this.btnBalance.addActionListener(this);
        this.commandPanel.add(this.btnBalance);

        // Withdraw button
        this.btnTransaction = new JButton("Do Transaction");
        this.btnTransaction.setPreferredSize(new Dimension(140, 30));
        this.btnTransaction.addActionListener(this);
        this.commandPanel.add(this.btnTransaction);

        // Exit button
        this.btnExit = new JButton("Exit");
        this.btnExit.setPreferredSize(new Dimension(140, 30));
        this.btnExit.addActionListener(this);
        this.commandPanel.add(this.btnExit);

        // Apply Interest button
        this.btnApplyInterest = new JButton("Apply Interest");
        this.btnApplyInterest.setPreferredSize(new Dimension(140, 30));
        this.btnApplyInterest.addActionListener(this);
        this.commandPanel.add(this.btnApplyInterest);

        // Calculate Interest button
        this.btnCalcInterest = new JButton("Show Interest");
        this.btnCalcInterest.setPreferredSize(new Dimension(140, 30));
        this.btnCalcInterest.addActionListener(this);
        this.commandPanel.add(this.btnCalcInterest);

        this.add(this.commandPanel);

    }

    @Override
    /**
     * Fuction to handle Click Events
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent event) {
        Object src = event.getSource();

        if(src.equals(this.btnCreate)) {
            createAccount();
        } else if (src.equals(this.btnExit)) {
            System.exit(0);
        }else if (src.equals(this.btnBalance)){
            this.checkBalance();
        }else if (src.equals(this.btnTransaction)){
            this.doTransaction();
        }else if (src.equals(this.btnCalcInterest)){
            this.calculateInterest();
        }else if (src.equals(this.btnApplyInterest)){
            this.applyInterest();
        }
    }



    private void createAccount() {
        Account account = null;
        if(this.radChecking.isSelected()) {
            account = new CheckingAccount(Bank.getNextAccountNumber(), Bank.getFee());
        }
        else {
            account = new SavingsAccount(Bank.getNextAccountNumber(), Bank.getIr());
        }
        bank.addAccount(account);
        showMessage("Your account has been created\nAccount Number: " + account.getAccountNumber() );
    }

    private void checkBalance() {
        try{
            int accountNumber = Integer.parseInt(this.txtAccountNumber.getText());
            Account account = bank.getAccount(accountNumber);

            if(account == null) {
                showError("No account exists with Account Number: " + this.txtAccountNumber.getText());
            }

            this.txtBalance.setText(String.format("$%.2f", account.getBalance()));
        }catch (Exception e) {
            showError(e.getMessage() + "\n" + e);
        }
    }

    private void doTransaction() {

        try{
            double amount = Double.parseDouble(this.txtAmount.getText());
            int accountNumber = Integer.parseInt(this.txtAccountNumber.getText());
            Account account = bank.getAccount(accountNumber);

            if (this.radDeposit.isSelected()) {
                if (bank.deposit(accountNumber, amount)) {
                    showMessage("Transaction is Successful!");
                    txtAmount.setText("");
                    double balance = bank.getAccount(accountNumber).getBalance();
                    txtBalance.setText(String.format("$%.2f", balance));
                } else {
                    showError("Transaction Failed! Try again");
                }
            }
            else {
                if (bank.withdraw(accountNumber, amount)) {
                    showMessage("Transaction is Successful!");
                    txtAmount.setText("");
                    double balance = bank.getAccount(accountNumber).getBalance();
                    txtBalance.setText(String.format("$%.2f", balance));
                } else {
                    showError("Transaction Failed! Try again");
                }
            }


        }catch (Exception e) {
            showError(e.getMessage() + "\n" + e);
        }
    }

    private void calculateInterest() {
        try{
            int accountNumber = Integer.parseInt(this.txtAccountNumber.getText());

            Account account = bank.getAccount(accountNumber);

            if(account instanceof SavingsAccount) {
                double interest = ((SavingsAccount) account).calcInterestRate();
                showMessage(String.format("Interest Earned: $%.2f", interest));
            }else {
                showError("This is not a Savings account!");
            }

        }catch (Exception e) {
            showError(e.getMessage() + "\n" + e);
        }
    }

    private void applyInterest() {
        try{
            int accountNumber = Integer.parseInt(this.txtAccountNumber.getText());

            Account account = bank.getAccount(accountNumber);

            if(account instanceof SavingsAccount) {

                double interest = ((SavingsAccount) account).calcInterestRate();

                bank.deposit(account.getAccountNumber(), interest);
                showMessage(("Interest has been added"));

                this.txtBalance.setText(String.format("$%.2f", account.getBalance()));
            }else {
                showError("This is not a Savings account!");
            }

        }catch (Exception e) {
            showError(e.getMessage() + "\n" + e);
        }
    }


    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Information", JOptionPane.ERROR_MESSAGE);
    }

}
