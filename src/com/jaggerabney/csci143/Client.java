package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week5.practiceit.*;

public class Client {
  public static void main(String[] args) {
    int[] testValues = { 1, 2, 3, 4, 5, 6, 7, 8 };

    for (int value : testValues) {
      PracticeIt.writeChars(value);
      System.out.println();
    }
  }
}