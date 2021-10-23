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
}
