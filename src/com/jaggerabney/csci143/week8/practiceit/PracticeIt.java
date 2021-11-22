package com.jaggerabney.csci143.week8.practiceit;

import java.util.*;

public class PracticeIt {
  public static List<Integer> alternate(List<Integer> list1, List<Integer> list2) {
    List<Integer> result = new ArrayList<>();
    int longerListSize = (list1.size() >= list2.size()) ? list1.size() : list2.size();

    for (int i = 0; i < longerListSize; i++) {
      if (i < list1.size()) {
        result.add(list1.get(i));
      }

      if (i < list2.size()) {
        result.add(list2.get(i));
      }
    }

    return result;
  }
}
