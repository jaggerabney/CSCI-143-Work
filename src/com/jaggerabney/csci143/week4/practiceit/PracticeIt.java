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

  public static void removeEvenLength(ArrayList<String> list) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).length() % 2 == 0) {
        list.remove(list.get(i));
        i--;
      }
    }
  }

  public static void doubleList(ArrayList<String> list) {
    String temp;

    for (int i = 0; i < list.size(); i++) {
      temp = list.get(i);
      list.add(i + 1, temp);
      i++;
    }
  }

  public static void minToFront(ArrayList<Integer> list) {
    int lowest = list.get(0);
    int indexOfLowest = 0;

    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) < lowest) {
        lowest = list.get(i);
        indexOfLowest = i;
      }
    }

    list.remove(indexOfLowest);
    list.add(0, lowest);
  }

  public static void removeDuplicates(ArrayList<String> list) {
    ArrayList<String> uniqueElements = new ArrayList<>();
    String currentElement;

    for (int i = 0; i < list.size(); i++) {
      currentElement = list.get(i);

      if (uniqueElements.contains(currentElement)) {
        list.remove(currentElement);
        i--;
      } else {
        uniqueElements.add(currentElement);
      }
    }
  }

  public static void removeInRange(ArrayList<Integer> list, int value, int start, int end) {
    int currentElement = 0;

    if (end < start) {
      int temp = start;
      start = end;
      end = temp;
    }

    ArrayList<Integer> sublist = new ArrayList<>(list.subList(start, end));

    list.subList(start, end).clear();
    for (int i = 0; i < sublist.size(); i++) {
      currentElement = sublist.get(i);

      if (currentElement == value) {
        sublist.remove(i);
        i--;
      }
    }
    list.addAll(start, sublist);
  }

  public static void stutter(ArrayList<String> list, int stretchFactor) {
    String temp;

    if (stretchFactor <= 0) {
      list.clear();
    }

    for (int i = 0; i < list.size(); i++) {
      temp = list.get(i);
      for (int j = 0; j < stretchFactor - 1; j++) {
        list.add(i + 1, temp);
        i++;
      }
    }
  }

  public static void markLength4(ArrayList<String> list) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).length() == 4) {
        list.add(i, "****");
        i++;
      }
    }
  }

  public static void removeShorterStrings(ArrayList<String> list) {
    int firstElementLength, secondElementLength, index;

    for (int i = 0; i < list.size() - 1; i += 2) {
      firstElementLength = list.get(i).length();
      secondElementLength = list.get(i + 1).length();
      index = (firstElementLength > secondElementLength) ? i + 1 : i;

      list.remove(index);
      i--;
    }
  }

  public static void filterRange(ArrayList<Integer> list, int min, int max) {
    int currentElement;

    for (int i = 0; i < list.size(); i++) {
      currentElement = list.get(i);

      if (currentElement >= min && currentElement <= max) {
        list.remove(i);
        i--;
      }
    }
  }
}
