package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week1.assignment.*;

public class Client {
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      MyInteger number = new MyInteger(i);

      System.out.println(number.get());
      System.out.println("n1 is even? " + number.isEven());
      System.out.println("n1 is prime? " + number.isPrime());
      System.out.println("n1 is odd? " + number.isOdd());
      System.out.println();
    }
  }
}