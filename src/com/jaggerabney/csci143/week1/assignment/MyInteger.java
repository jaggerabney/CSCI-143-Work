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
    return (value % 2 == 0);
  }
}
