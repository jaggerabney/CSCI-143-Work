package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week5.practiceit.*;

public class Client {
  public static void main(String[] args) {
    int[] testValues = { 1, 2, 3, 4 };

    for (int value : testValues) {
      System.out.println(PracticeIt.multiplyEvens(value));
    }
  }
}