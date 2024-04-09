import java.util.ArrayList;

/**
 * Manage Bank Accounts
 * @author aciuvaga
 */
public class Bank {

    //Account Number creator
    private static int accountCounter = 1000;
    private static double FEE= 2.5;
    private static double IR= 0.05;


    //Collection of accounts
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    /**
     * Find an acount with given account number
     * @param accountNumber
     * @return
     */
    public Account getAccount(int accountNumber) {

        for(Account account: accounts) {
            if(account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null;
    }

    /**
     * Deposit amount to an account
     * @param accountNumber
     * @param amount
     * @return
     */
    public boolean deposit(int accountNumber, double amount) {
        Account account = this.getAccount(accountNumber);
        if(account == null) {
            return false;
        }

        if(amount > 0){
            account.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(int accountNumber, double amount) {
        Account account = this.getAccount(accountNumber);
        if (account == null) {
            return false;
        }

        if(amount <= 0 || account.getBalance() < amount) {
            return false;
        }
        account.withdraw(amount);
        return true;
    }

    public static int getNextAccountNumber() {
        accountCounter++;
        return accountCounter;
    }

    public static double getFee() {
        return FEE;
    }

    public static double getIr() {
        return IR;
    }
}
