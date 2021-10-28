package com.jaggerabney.csci143.week5.practiceit;

public class PracticeIt {
  public static String starString(int times) {
    if (times == 0) {
      return "*";
    } else if (times > 0) {
      return starString(times - 1) + starString(times - 1);
    } else {
      throw new IllegalArgumentException("times must be less than zero.");
    }
  }

  public static void writeNums(int times) {
    if (times == 1) {
      System.out.print("1");
    } else if (times > 1) {
      writeNums(times - 1);
      System.out.print(", " + times);
    } else {
      throw new IllegalArgumentException("times must be greater than one.");
    }
  }
}
