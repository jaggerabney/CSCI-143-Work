package com.jaggerabney.csci143.week7.practiceit;

import java.util.NoSuchElementException;

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

  public int min() {
    if (front == null)
      throw new NoSuchElementException("list cannot be null");

    ListNode current = front;
    int min = front.data;

    while (current != null) {
      if (current.data < min) {
        min = current.data;
      }

      current = current.next;
    }

    return min;
  }

  public boolean isSorted() {
    boolean isSorted = true;
    ListNode current = front;
    int previousData = Integer.MIN_VALUE;

    while (current != null) {
      if (current.data < previousData) {
        isSorted = false;
      }

      previousData = current.data;
      current = current.next;
    }

    return isSorted;
  }

  public int lastIndexOf(int value) {
    int index = 0;
    int result = -1;
    ListNode current = front;

    while (current != null) {
      if (current.data == value) {
        result = index;
      }

      index++;
      current = current.next;
    }

    return result;
  }
}
