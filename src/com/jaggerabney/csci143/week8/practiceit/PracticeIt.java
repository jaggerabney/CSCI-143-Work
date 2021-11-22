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

  public static int countUnique(List<Integer> list) {
    Set<Integer> uniques = new HashSet<>();
    int numUniques = 0;

    for (int element : list) {
      if (!uniques.contains(element)) {
        uniques.add(element);
        numUniques++;
      }
    }

    return numUniques;
  }

  public static int countCommon(List<Integer> list1, List<Integer> list2) {
    Set<Integer> list1uniques = new HashSet<>(list1);
    Set<Integer> list2uniques = new HashSet<>(list2);
    int numUniques = 0;

    for (int element : list1uniques) {
      if (list2uniques.contains(element)) {
        numUniques++;
      }
    }

    return numUniques;
  }

  public static int maxLength(Set<String> set) {
    int longestStringLength = 0;

    for (String element : set) {
      if (element.length() > longestStringLength) {
        longestStringLength = element.length();
      }
    }

    return longestStringLength;
  }

  public static boolean hasOdd(Set<Integer> set) {
    boolean hasOdd = false;

    for (int element : set) {
      if (element % 2 != 0) {
        hasOdd = true;
      }
    }

    return hasOdd;
  }

  public static void removeEvenLength(Set<String> set) {
    Set<String> stringsToRemove = new HashSet<>();

    for (String element : set) {
      if (element.length() % 2 == 0) {
        stringsToRemove.add(element);
      }
    }

    set.removeAll(stringsToRemove);
  }

  public static boolean contains3(List<String> list) {
    Map<String, Integer> storage = new LinkedHashMap<>();

    for (String element : list) {
      if (storage.containsKey(element)) {
        storage.put(element, storage.get(element) + 1);
      } else {
        storage.put(element, 1);
      }
    }

    for (int value : storage.values()) {
      if (value >= 3) {
        return true;
      }
    }

    return false;
  }
}
