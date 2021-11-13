package com.jaggerabney.csci143.week7.practiceit;

import com.jaggerabney.csci143.week7.assignment.*;

public class PracticeIt extends LinkedIntList {
  public void set(int index, int value) {
    ListNode current = front;
    int listIndex = 0;

    while (current != null) {
      if (listIndex == index) {
        current.data = value;
      }

      listIndex++;
      current = current.next;
    }
  }
}
