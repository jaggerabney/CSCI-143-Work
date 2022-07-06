package com.jaggerabney.csci143.week2.classcoding;

public class Marketer extends Employee {
  public Marketer(int yearsWorked) {
    super(yearsWorked);
  }

  @Override
  public double getSalary() {
    return super.getSalary() + 10000.0;
  }
}
