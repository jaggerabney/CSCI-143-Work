package com.jaggerabney.csci143.week2.projects;

import java.util.ArrayList;

public class Project1 {
  private Project1() {
  }

  public static void removeDuplicate(ArrayList<Integer> list) {
    ArrayList<Integer> uniqueItemsInList = new ArrayList<Integer>();
    int currentItem;

    for (int i = 0; i < list.size(); i++) {
      currentItem = list.get(i);
      if (uniqueItemsInList.contains(currentItem)) {
        list.remove(i);
        i--;
      } else {
        uniqueItemsInList.add(currentItem);
      }
    }
  }
}
