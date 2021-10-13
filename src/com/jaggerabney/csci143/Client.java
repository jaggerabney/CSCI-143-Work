package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week2.classcoding.*;

public class Client {
  public static void main(String[] args) {
    Employee emp = new Employee();
    Marketer john = new Marketer();
    Lawyer lisa = new Lawyer();

    System.out.println(emp.getSalary());
    System.out.println(john.getSalary());
    System.out.println(lisa.getHours());
    System.out.println(lisa.getVacationForm());
  }
}