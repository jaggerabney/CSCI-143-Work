package com.jaggerabney.csci143.week2.classcoding;

public class Lawyer extends Employee {
  @Override
  public int getVacation() {
    return super.getVacation() + 5;
  }

  @Override
  public String getVacationForm() {
    return "pink";
  }
}
