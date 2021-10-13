package com.jaggerabney.csci143.week2.classcoding;

public class Marketer extends Employee {
  @Override
  public double getSalary() {
    return super.getSalary() + 10000.0;
  }
}
