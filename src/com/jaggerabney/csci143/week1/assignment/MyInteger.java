package com.jaggerabney.csci143.week1.assignment;

public class MyInteger {
  private int value;

  public MyInteger(int value) {
    this.value = value;
  }

  public int get() {
    return value;
  }

  public boolean isEven() {
    return MyInteger.isEven(value);
  }

  public boolean isOdd() {
    return MyInteger.isOdd(value);
  }

  public boolean isPrime() {
    return MyInteger.isPrime(value);
  }
  

  public static boolean isEven(int value) {
    return (value % 2 == 0);
  }

  public static boolean isOdd(int value) {
    return !MyInteger.isEven(value);
  }

  public static boolean isPrime(int value) {
    boolean isPrime = true;

    if (value >= 2) {
      for (int i = 2; i < value; i++) {
        if (value % i == 0) { // if value is divisible by anything
          System.out.println(i);
          isPrime = false;
        } 
      }
    }

    return isPrime;
  }
}
