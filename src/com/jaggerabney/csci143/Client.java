package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week2.classcoding.*;

public class Client {
  public static void main(String[] args) {
    Employee employee = new Employee();
    Marketer marketer = new Marketer();
    Lawyer lawyer = new Lawyer();
    Secretary secretary = new Secretary();
    LegalSecretary legalSecretary = new LegalSecretary();

    System.out.println(employee);
    System.out.println(marketer);
    System.out.println(lawyer);
    System.out.println(secretary);
    System.out.println(legalSecretary);
  }
}