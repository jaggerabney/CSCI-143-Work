package com.jaggerabney.csci143.week5.misc;

public class Misc {
  public static int sum(int[] array, int n) {
    if (n == 0) {
      return 0;
    } else {
      return array[n - 1] + sum(array, n - 1);
    }
  }
}
