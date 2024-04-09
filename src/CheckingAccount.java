public class CheckingAccount extends Account{

    // Default Transaction Fee
    private static double fee= 2.5;


    public CheckingAccount() {
        super();
    }

    /**
     * Parameter constructor to initialize Checking Account with a custom Account Number
     * and a Customer Transaction Fee
     */
    public CheckingAccount(int accountNumber, double fee ) {
        super(accountNumber);
        CheckingAccount.fee = fee;
    }



    @Override
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);

            balance -= fee;
            System.out.printf("Fee %.2f Applied%n", fee);
            System.out.printf("Current Balance is: %.2f%n", balance);

        }else{
            System.out.println("A negative amount cannot be deposited");
        }
    }

    @Override
    public void withdraw(double amount) {

        if(amount > 0) {
            if ((amount + fee) <= balance){
                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                balance -= fee;
                System.out.printf("Fee of %.2f applied%n", fee);
                System.out.printf("Current Balance is %.2f%n", balance);
            }

        }else{
            System.out.println("Negative amount cannot be withdrawn");
        }
    }
}
