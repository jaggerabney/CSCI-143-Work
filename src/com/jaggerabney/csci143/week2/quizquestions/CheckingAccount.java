package com.jaggerabney.csci143.week2.quizquestions;

public class CheckingAccount extends BankAccount {
  private boolean overdraft;

  public CheckingAccount(String name, boolean overdraft) {
    super(name);
    this.overdraft = overdraft;
  }

  public boolean hasOverdraft() {
    return overdraft;
  }

  public boolean clearCheck(double amount) {
    if (amount < getBalance() || overdraft) {
      withdraw(amount);
      return true;
    } else {
      return false;
    }
  }
}

class BankAccount {
  private double balance;
  private String name;

  public BankAccount(String name) {
    this.name = name;
  }

  public double getBalance() {
    return balance;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }
}