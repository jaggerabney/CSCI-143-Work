package com.jaggerabney.csci143.week7.assignment;

import java.util.NoSuchElementException;

public class LinkedIntList {
  private ListNode front;

  public LinkedIntList() {
    this.front = null;
  }

  public void add(int data) {
    if (front == null) {
      front = new ListNode(data);
    } else {
      ListNode current = front;

      while (current.next != null) {
        current = current.next;
      }

      current.next = new ListNode(data);
    }
  }

  @Override
  public String toString() {
    String result = "[";

    if (front == null) {
      throw new NoSuchElementException();
    } else {
      ListNode current = front;

      while (current != null) {
        result += current.data + ((current.next != null) ? ", " : "");
        current = current.next;
      }

      result += "]";
      return result;
    }
  }

  public int size() {
    int size = 0;
    ListNode current = front;

    while (current != null) {
      size++;
      current = current.next;
    }

    return size;
  }

  public boolean isEmpty() {
    return front == null;
  }

  public void clear() {
    this.front = null;
  }

  public int indexOf(int value) {
    int index = 0;
    ListNode current = front;

    while (current != null) {
      if (current.data == value) {
        return index;
      }

      index++;
      current = current.next;
    }

    return -1;
  }
}
