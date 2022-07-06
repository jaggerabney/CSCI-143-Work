package com.jaggerabney.csci143.week5.projects;

public class Exercise18_03 {
  public static int gcd(int m, int n) {
    if (m % n == 0) {
      return n;
    } else {
      return gcd(n, m % n);
    }
  }
}
