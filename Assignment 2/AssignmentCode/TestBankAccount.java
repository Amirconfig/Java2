// Khanmohammadi Amir Hosein, 991646689
// This is a Java class that tests the BankAccount and its 
// subclasses, CheckingAccount and SavingsAccount, by creating 
// objects of these classes, performing actions such as withdrawal 
// and deposit, setting annual interest rate, and displaying account 
// information and monthly interest amount. The accountInformation 
// method is used to display the information of a BankAccount object, 
// which is accomplished by calling the toString method.
//2023-02-03

public class TestBankAccount {
    public static void main(String[] args) {
        // Create checking account
        CheckingAccount checking = new CheckingAccount(1001, "John P Smith", 20000);
        // Create savings account
        SavingsAccount savings = new SavingsAccount(1002, "Janet E Holand", 10000);

        // Withdrawal from checking account
        checking.withdraw(2500);

        // Deposit to savings account
        savings.deposit(3000);

        // Set annual interest rate for savings account
        SavingsAccount.setAnnualInterestRate(0.045);

        // Display information for checking account
        accountInformation(checking);

        // Display information for savings account
        accountInformation(savings);

        // Display monthly interest amount for savings account
        System.out.println("Monthly interest amount of savings account is: " + savings.getMonthlyInterestRate());

    }

    public static void accountInformation(BankAccount account) {
        System.out.println(account);
    }
}
