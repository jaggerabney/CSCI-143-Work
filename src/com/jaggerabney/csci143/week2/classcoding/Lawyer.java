package com.jaggerabney.csci143.week2.classcoding;

public class Lawyer extends Employee {
  public Lawyer(int yearsWorked) {
    super(yearsWorked);
  }

  @Override
  public double getSalary() {
    return super.getSalary() + (5000.0 * yearsWorked);
  }

  @Override
  public int getVacation() {
    return super.getVacation() + 5;
  }

  @Override
  public String getVacationForm() {
    return "pink";
  }
}
