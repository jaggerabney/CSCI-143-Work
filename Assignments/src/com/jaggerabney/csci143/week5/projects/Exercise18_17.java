package com.jaggerabney.csci143.week5.projects;

import java.util.*;

public class Exercise18_17 {
  public static int count(char[] chars, char ch) {
    return count(chars, ch, 0);
  }

  public static int count(char[] chars, char ch, int high) {
    if (chars.length == 1) {
      return high + ((chars[0] == ch) ? 1 : 0);
    } else {
      int matches = (chars[0] == ch) ? 1 : 0;
      return count(Arrays.copyOfRange(chars, 1, chars.length), ch, high + matches);
    }
  }
}
