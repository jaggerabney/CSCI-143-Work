package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week5.practiceit.*;

public class Client {
  public static void main(String[] args) {
    int[] values = new int[] { 0, 1, 2, 3, 4 };
    for (int i : values) {
      System.out.println(PracticeIt.starString(i));
    }
  }
}