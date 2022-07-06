package com.jaggerabney.csci143.week2.classcoding;

public class Secretary extends Employee {
  public Secretary(int yearsWorked) {
    super(yearsWorked);
  }

  @Override
  public double getSalary() {
    return super.getSalary() + 5000;
  }
}
