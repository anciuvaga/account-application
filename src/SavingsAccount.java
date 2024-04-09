public class SavingsAccount extends Account{

    // Default Transaction Fee
    private double interestRate;


    public SavingsAccount() {
        super();
    }

    /**
     * Parameter constructor to initialize Savings Account with a custom Account Number
     * and interest rate
     */
    public SavingsAccount(int accountNumber, double interestRate ) {
        super(accountNumber);
        this.interestRate=interestRate;
    }


    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterestRate() {
        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calcInterestRate();
        System.out.printf("Interest amount %.2f added to balance%n" , interest);
        deposit(interest);
    }

    @Override
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);
            System.out.printf("Current Balance is: %.2f%n", balance);

        }else{
            System.out.println("A negative amount cannot be deposited");
        }
    }

    @Override
    public void withdraw(double amount) {

        if(amount > 0) {
            if (amount <= balance){
                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                System.out.printf("Current Balance is %.2f%n", balance);
            }

        }else{
            System.out.println("Negative amount cannot be withdrawn");
        }
    }
}
