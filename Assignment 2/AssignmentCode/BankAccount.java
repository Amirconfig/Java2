// Khanmohammadi Amir Hosein, 991646689
// This is a Java class that implements a Bank Account. 
// The class has instance variables for account number, name, 
// balance, annual interest rate, and date created. It also has 
// methods for accessing and setting the values of these variables, 
// as well as for withdrawing and depositing money from the account, 
// and returning a string representation of the account information.
//2023-02-03

import java.util.Date;

public class BankAccount {
  private int accountNumber;
  private String name;
  protected double balance;
  private static double annualInterestRate;
  private Date dateCreated;

  public BankAccount() {
    this.accountNumber = 1000;
    this.name = "";
    this.balance = 0;
    this.dateCreated = new Date();
  }

  public BankAccount(int accountNumber, String name, double balance) {
    this.accountNumber = accountNumber;
    this.name = name;
    this.balance = balance;
    this.dateCreated = new Date();
  }

  public int getAccountNumber() {
    return this.accountNumber;
  }

  public void setAccountNumber(int accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  public static void setAnnualInterestRate(double annualInterestRate) {
    BankAccount.annualInterestRate = annualInterestRate;
  }

  public Date getDateCreated() {
    return this.dateCreated;
  }

  public void withdraw(double amount) {
    this.balance -= amount;
  }

  public void deposit(double amount) {
    this.balance += amount;
  }

  @Override
  public String toString() {
    return String.format(
        "accountNumber: %d\nAccount holder's Name: %s\nAccountBalance: %.2f\nDate Account Created: %s",
        this.accountNumber, this.name, this.balance, this.dateCreated);
  }
}
