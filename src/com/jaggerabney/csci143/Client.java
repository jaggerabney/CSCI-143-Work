package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week2.classcoding.*;

public class Client {
  public static void main(String[] args) {
    Employee[] employees = new Employee[] { new Employee(), new Lawyer(), new Marketer(), new Secretary(),
        new LegalSecretary() };

    for (Employee employee : employees) {
      System.out.println(employee);
    }
  }
}