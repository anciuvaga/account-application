import java.util.Scanner;

public class AccountDriver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create an array of 10 accounts
        Account [] accounts = new Account[10];
        int numAccounts = 0;
        
        int choice;
        do{
            choice = menu(input);
            System.out.println();
            
            if(choice == 1) {
                accounts[numAccounts++] = createAccount(input);
            } else if (choice == 2) {
               doDeposit(accounts, numAccounts, input);
            } else if (choice == 3) {
                doWithdraw(accounts, numAccounts, input);
            } else if (choice == 4) {
                applyInterest(accounts, numAccounts, input);
            }else{
                System.out.println("GoodBye!");
            }
            System.out.println();

        }while(choice != 5);
    }

    public static int accountMenu (Scanner input) {
        System.out.println("Select Account Type");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;

        do{
            System.out.println("Enter choice: ");
            choice = input.nextInt();
        }while(choice < 1 || choice > 2);
        return choice;
    }

    public static int searchAccount(Account [] accounts, int count, int accountNumber) {
         for(int i=0; i < count; i++) {
             if(accounts[i].getAccountNumber() == accountNumber) {
                 return i;
             }
         }
         return -1;
    }
    public static void doDeposit(Account[] accounts, int count, Scanner input) {
        // Get the account number

        System.out.print("\nPlease enter account number: ");
        int accountNumber = input.nextInt();

        // Search the account
        int index = searchAccount(accounts, count, accountNumber);

        // Amount

        if(index >= 0) {
            System.out.print("Please enter Deposit Amount\n");
            double amount = input.nextDouble();
            accounts[index].deposit(amount);
        }else {
            System.out.println("No account exists with AccountNumber: " + accountNumber);
        }
    }

    public static void doWithdraw(Account[] accounts, int count, Scanner input) {
        // Get the account number

        System.out.print("\nPlease enter account number: ");
        int accountNumber = input.nextInt();

        // Search the account
        int index = searchAccount(accounts, count, accountNumber);

        // Amount
        System.out.print("Please enter Withdraw Amount");

        if(index >= 0) {
            double amount = input.nextDouble();
            accounts[index].withdraw(amount);
        }else {
            System.out.println("No account exists with AccountNumber: " + accountNumber);
        }
    }

    public static void applyInterest(Account [] accounts, int count, Scanner input) {
        // Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = input.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);
        if(index >= 0) {
            // must be instanced of Savings Account
            if(accounts[index] instanceof  SavingsAccount) {
                ((SavingsAccount) accounts[index]).applyInterest();

            }
        }

    }



    /**
     *Function to create a new Account
     * @return
     */
    public static Account createAccount(Scanner input) {
         Account account = null;
         int choice  = accountMenu(input);
         int accountNumber;
        System.out.print("Enter Account Number: ");
        accountNumber = input.nextInt();

        if(choice ==1) { // Checking account
            System.out.print("Enter Transaction Fee: ");
            double fee = input.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        }else{ // Savings account
            System.out.println("Please enter Interest Rate: ");
            double interestRate = input.nextDouble();
            account = new SavingsAccount(accountNumber, interestRate);
        }
        return account;
    }


    /**
     * Menu to display options and get the user's selection
     * @param input
     * @return
     */
    public static int menu(Scanner input) {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;
        do {
            System.out.println("Enter choice");
            choice = input.nextInt();
        }while (choice < 1 || choice > 5);

        return choice;
    }
}
