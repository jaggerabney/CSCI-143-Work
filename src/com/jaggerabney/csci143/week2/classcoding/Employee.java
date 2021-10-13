package com.jaggerabney.csci143.week2.classcoding;

public class Employee {
  public int getHours() {
    return 40;
  }

  public double getSalary() {
    return 40000.0;
  }

  public int getVacation() {
    return 10;
  }

  public String getVacationForm() {
    return "yellow";
  }

  @Override
  public String toString() {
    return "This employee works " + getHours() + " a week, is paid " + getSalary() + " a year, gets " + getVacation()
        + " days of vacation a year, and uses a " + getVacationForm() + " vacation form.";
  }
}
