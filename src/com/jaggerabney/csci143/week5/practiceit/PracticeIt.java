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

  public static void writeSequence(int times) {
    if (times == 1) {
      System.out.print("1 ");
    } else if (times > 1) {
      System.out.print(((times + 1) / 2) + " ");
      if (times > 2) {
        writeSequence(times - 2);
      }
      System.out.print(((times + 1) / 2) + " ");
    } else {
      throw new IllegalArgumentException("times must be greater than one.");
    }
  }

  public static void writeSquares(int n) {
    if (n == 1) {
      System.out.print("1");
    } else if (n > 1) {
      if (n % 2 == 0) { // n is even
        System.out.print(((n - 1) * (n - 1)));
        if (n != 2) {
          System.out.print(", ");
          writeSquares(n - 2);
        }
        System.out.print(", " + (n * n));
      } else { // n is odd
        System.out.print((n * n) + ", ");
        if (n != 2)
          writeSquares(n - 2);
        System.out.print(", " + ((n - 1) * (n - 1)));
      }
    } else {
      throw new IllegalArgumentException("n must be greater than one.");
    }
  }
}
