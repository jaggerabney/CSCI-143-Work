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

  public static void removeInRange(List<Integer> list, int value, int start, int end) {
    if (start < end) {
      removeInRange(list, value, end, start);
    }

    ArrayList<Integer> workingList = new ArrayList<>(list);

    for (int i = 0; i < workingList.size(); i++) {
      if (i >= start && i < end && workingList.get(i) == value) {
        workingList.remove(i);
        i--;
        end--;
      }
    }

    list.clear();
    list.addAll(workingList);
  }
}
