// Khanmohammadi Amir Hosein, 991646689
// This is a Java class that extends the BankAccount class 
// and creates a CheckingAccount type of bank account with
// an overdraft limit and a unique toString method that includes 
// "Account type: Checking".
//2023-02-03

public class CheckingAccount extends BankAccount {
    protected int overdraftLimit = 6000;

    public CheckingAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
    }

    @Override
    public String toString() {
        return super.toString() + "\nAccount type: Checking\n";
    }
}
