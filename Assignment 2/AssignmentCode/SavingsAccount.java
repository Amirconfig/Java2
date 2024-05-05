// Khanmohammadi Amir Hosein, 991646689
// This is a Java class that extends the BankAccount class a
// nd creates a SavingsAccount type of bank account with methods 
// to calculate and return the monthly interest rate and monthly 
// interest, and a unique toString method that includes 
// "Account type: Savings".
//2023-02-03

public class SavingsAccount extends BankAccount {
    private static double annualInterestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return balance * (annualInterestRate / 12);
    }

    public double getMonthlyInterest() {
        return getBalance() * getMonthlyInterestRate();
    }

    @Override
    public String toString() {
        return super.toString() + "\nAccount type: Savings\n";
    }

}
