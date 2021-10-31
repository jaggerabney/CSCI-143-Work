package com.jaggerabney.csci143.week5.projects;

public class Exercise18_11 {
  public static int sumDigits(long n) {
    if (n < 10) { // if n is a single-digit number
      return (int) n;
    } else { // if n is a two-or-more-digit number
      int firstDigit = Character.getNumericValue(String.valueOf(n).charAt(0));
      return firstDigit + sumDigits(Long.parseLong(String.valueOf(n).substring(1)));
    }
  }
}
