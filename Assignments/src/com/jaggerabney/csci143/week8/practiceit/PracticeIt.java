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

  public static boolean isUnique(Map<String, String> map) {
    Set<String> uniques = new HashSet<>();
    boolean isUnique = true;

    for (String value : map.values()) {
      if (uniques.contains(value)) {
        isUnique = false;
      } else {
        uniques.add(value);
      }
    }

    return isUnique;
  }

  public static Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
    Map<String, Integer> result = new HashMap<>();

    for (String element : map1.keySet()) {
      if (map2.containsKey(element)) {
        if (map2.get(element) == map1.get(element)) {
          result.put(element, map1.get(element));
        }
      }
    }

    return result;
  }

  public static int maxOccurrences(List<Integer> list) {
    if (list.isEmpty())
      return 0;

    Map<Integer, Integer> occurrences = new HashMap<>();

    for (int element : list) {
      if (occurrences.containsKey(element)) {
        occurrences.put(element, occurrences.get(element) + 1);
      } else {
        occurrences.put(element, 1);
      }
    }

    return Collections.max(occurrences.values());
  }

  public static Map<String, Integer> reverse(Map<Integer, String> map) {
    Map<String, Integer> result = new HashMap<>();

    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      if (!result.keySet().contains(entry.getValue())) {
        result.put(entry.getValue(), entry.getKey());
      }
    }

    return result;
  }

  public static int rarest(Map<String, Integer> map) {
    if (map.isEmpty())
      throw new IllegalArgumentException("map cannot be empty");

    Map<Integer, Integer> occurrences = new HashMap<>();
    TreeSet<Integer> rarestValues = new TreeSet<>();
    int rarest;

    for (int value : map.values()) {
      if (occurrences.containsKey(value)) {
        occurrences.put(value, occurrences.get(value) + 1);
      } else {
        occurrences.put(value, 1);
      }
    }

    rarest = Collections.min(occurrences.values());

    for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
      if (entry.getValue() == rarest) {
        rarestValues.add(entry.getKey());
      }
    }

    return rarestValues.first();
  }

  public static Map<String, Integer> pairCounts(List<String> list) {
    Map<String, Integer> pairCounts = new TreeMap<>();

    for (String element : list) {
      if (element.length() >= 2) {
        for (int i = 0; i < element.length() - 1; i++) {
          String key = element.substring(i, i + 2);

          if (pairCounts.containsKey(key)) {
            pairCounts.put(key, pairCounts.get(key) + 1);
          } else {
            pairCounts.put(key, 1);
          }
        }

      }
    }

    return pairCounts;
  }
}
