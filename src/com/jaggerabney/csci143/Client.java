package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week5.practiceit.*;

public class Client {
  public static void main(String[] args) {
    int[] values = new int[] { 5, 1, 8 };
    for (int i : values) {
      PracticeIt.writeSquares(i);
      System.out.println();
    }
  }
}