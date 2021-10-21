package com.jaggerabney.csci143.week4.practiceit;

import java.util.*;

public class PracticeIt {
  public static void swapPairs(ArrayList<String> list) {
    String first, second;

    for (int i = 0; i < list.size() - 1; i += 2) {
      first = list.get(i);
      second = list.get(i + 1);
      list.set(i, second);
      list.set(i + 1, first);
    }
  }
}
