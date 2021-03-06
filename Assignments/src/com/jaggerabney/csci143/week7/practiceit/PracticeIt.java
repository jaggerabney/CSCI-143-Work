package com.jaggerabney.csci143.week7.practiceit;

import java.util.NoSuchElementException;

import com.jaggerabney.csci143.week7.assignment.*;

public class PracticeIt extends LinkedIntList {
  public PracticeIt(int[] values) {
    super(values);
  }

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

  public int countDuplicates() {
    int duplicates = 0;
    ListNode current = front;

    if (current != null) {
      while (current.next != null) {
        if (current.data == current.next.data) {
          duplicates++;
        }

        current = current.next;
      }
    }

    return duplicates;
  }

  public boolean hasTwoConsecutive() {
    boolean hasTwoConsecutive = false;
    ListNode current = front;

    if (current != null) {
      while (current.next != null) {
        if (current.data + 1 == current.next.data) {
          hasTwoConsecutive = true;
        }

        current = current.next;
      }
    }

    return hasTwoConsecutive;
  }

  public int deleteBack() {
    if (front == null)
      throw new NoSuchElementException();

    ListNode current = front;
    int result;

    if (front.next == null) {
      result = front.data;
      front = null;
      return result;
    }

    while (current.next.next != null) {
      current = current.next;
    }

    result = current.next.data;
    current.next = null;
    return result;
  }

  public void switchPairs() {
    ListNode current = front;
    int storage;

    while (current != null && current.next != null) {
      storage = current.next.data;

      current.next.data = current.data;
      current.data = storage;
      current = current.next.next;
    }
  }

  public void stutter() {
    ListNode current = front;
    ListNode rest = null;

    while (current != null) {
      if (current.next != null) {
        rest = current.next;
      } else {
        rest = null;
      }

      current.next = new ListNode(current.data);

      if (rest != null)
        current.next.next = rest;
      current = current.next.next;
    }
  }

  public void stretch(int n) {
    ListNode current = front;

    while (current != null) {
      for (int i = 1; i < n; i++) {
        current.next = new ListNode(current.data, current.next);
        current = current.next;
      }

      current = current.next;
    }
  }

  public void compress(int n) {
    ListNode current = front;
    ListNode rest = null;

    while (current != null) {
      for (int i = 1; i < n; i++) {
        if (current.next != null) {
          rest = (current.next.next != null) ? current.next.next : null;
          current.data += current.next.data;
          current.next = rest;
        }
      }

      current = current.next;
    }
  }

  public void split() {
    ListNode current = front;
    ListNode rest = null;

    while (current != null && current.next != null) {
      if (current.next.data < 0) {
        rest = current.next.next;
        current.next.next = front;
        front = current.next;
        current.next = rest;
      } else {
        current = current.next;
      }
    }
  }

  public void transferFrom(LinkedIntList list) {
    if (list.front == null) {
      return;
    } else if (front == null) {
      front = list.front;
      list.front = null;
      return;
    }

    ListNode current = front;

    while (current.next != null) {
      current = current.next;
    }

    current.next = list.front;
    list.front = null;
  }

  public void removeAll(int value) {
    while (front != null && front.data == value) {
      front = front.next;
    }

    ListNode current = front;

    while (current != null && current.next != null) {
      if (current.next.data == value) {
        current.next = current.next.next;
        continue;
      }

      current = current.next;
    }
  }

  public boolean equals2(LinkedIntList list) {
    ListNode thisListCurrent = front;
    ListNode otherListCurrent = list.front;

    while (thisListCurrent != null && otherListCurrent != null) {
      if (thisListCurrent.data != otherListCurrent.data) {
        return false;
      } else if ((thisListCurrent.next == null) != (otherListCurrent.next == null)) {
        return false;
      }

      thisListCurrent = thisListCurrent.next;
      otherListCurrent = otherListCurrent.next;
    }

    return true;
  }

  public LinkedIntList removeEvens() {
    if (front == null)
      return new LinkedIntList();

    LinkedIntList evens = new LinkedIntList();

    evens.add(front.data);
    front = front.next;

    ListNode current = front;
    int position = 2;

    while (current != null && current.next != null) {
      if (position % 2 == 0) {
        evens.add(current.next.data);
        current.next = current.next.next;
        position++;
        continue;
      }

      position++;
      current = current.next;
    }

    return evens;
  }

  public void removeRange(int start, int end) {
    if (start < 0 || end < 0) {
      throw new IllegalArgumentException("range must be greater than zero");
    }

    ListNode current = front;
    ListNode previous = null;
    int position = 0;

    while (current != null) {
      if (inRange(position, start, end)) {
        if (previous != null) {
          previous.next = current.next;
        } else {
          front = front.next;
        }
        current = current.next;
        position++;
        continue;
      }

      position++;
      previous = current;
      current = current.next;
    }
  }

  private boolean inRange(int value, int start, int end) {
    return (start <= value && end >= value);
  }

  public void doubleList() {
    ListNode current = front;
    int originalSize = 0;

    while (current != null) {
      originalSize++;
      current = current.next;
    }

    current = front;

    while (originalSize > 0) {
      add(current.data);
      originalSize--;
      current = current.next;
    }
  }

  public void rotate() {
    ListNode current = front;
    ListNode rest = front.next;

    while (current.next != null) {
      current = current.next;
    }

    current.next = front;
    current.next.next = null;
    front = rest;
  }

  public void shift() {
    if (front == null)
      return;

    ListNode current = front;

    for (int i = 0; i < size() / 2; i++) {
      add(current.next.data);
      current.next = current.next.next;
      current = current.next;
    }
  }
}
