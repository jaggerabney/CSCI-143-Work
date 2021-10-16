package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week2.classcoding.*;

public class Client {
  public static void main(String[] args) {
    Employee[] employees = new Employee[] { new Employee(5), new Lawyer(2), new Marketer(10), new Secretary(4),
        new LegalSecretary(9) };

    for (Employee employee : employees) {
      System.out.println(employee);
    }
  }
}