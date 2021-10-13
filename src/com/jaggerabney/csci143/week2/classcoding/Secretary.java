package com.jaggerabney.csci143.week2.classcoding;

public class Secretary extends Employee {
  @Override
  public double getSalary() {
    return super.getSalary() + 5000;
  }
}
