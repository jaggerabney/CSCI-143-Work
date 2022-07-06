package com.jaggerabney.csci143.week7.assignment;

import java.util.NoSuchElementException;

public class LinkedIntList {
  // reference to first ListNode in the LinkedList
  public ListNode front;

  public LinkedIntList() {
    this.front = null;
  }

  public LinkedIntList(int[] values) {
    addAll(values);
  }

  // basic add method
  public void add(int data) {
    // initializes front to a ListNode with the given value if
    // there are no ListNodes in the LinkedList
    if (front == null) {
      front = new ListNode(data);
    } else {
      // otherwise, loops through the LinkedList until the end,
      // creates a new ListNode with the given data value, and appends
      // that ListNode to the end of the LinkedList
      ListNode current = front;

      while (current.next != null) {
        current = current.next;
      }

      current.next = new ListNode(data);
    }
  }

  @Override
  public String toString() {
    // instantiates a String to be returned
    String result = "[";

    // throws NoSuchElementException if the List is empty
    if (front == null) {
      throw new NoSuchElementException();
    } else {
      // otherwise, loops through the LinkedList until the endm
      // adding the value of each element to the result String as
      // the loop progresses
      ListNode current = front;

      while (current != null) {
        // if the current ListNode is linked to another ListNode,
        // add a comma; otherwise, do not
        result += current.data + ((current.next != null) ? ", " : "");
        current = current.next;
      }

      // returns the result
      result += "]";
      return result;
    }
  }

  // loops through the ListNodes of the LinkedList, incrementing a
  // size int for each ListNode that is processed before returning
  // the result
  public int size() {
    int size = 0;
    ListNode current = front;

    while (current != null) {
      size++;
      current = current.next;
    }

    return size;
  }

  // returns true if there is no front ListNode, and true otherwise
  // this makes sense because the list can only be empty if there are no
  // elements within it, and since ListNodes are accessed through ListNodes,
  // this can only be if front is empty (i.e. null)
  public boolean isEmpty() {
    return front == null;
  }

  // clears the list by removing the front ListNode
  public void clear() {
    this.front = null;
  }

  // loops through the ListNodes of the LinkedList until either the passed
  // value is found, in which case the index of the value is returned, or
  // until the end of the list is reached, in which case -1 is returned
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

  // loops through the ListNodes of the LinkedList, looking to see if each
  // individual element's "data" field equals the passed value; returns
  // true if this is the case, and false if it isn't
  public boolean contains(int value) {
    boolean containsValue = false;
    ListNode current = front;

    while (current != null) {
      if (current.data == value) {
        containsValue = true;
      }

      current = current.next;
    }

    return containsValue;
  }

  public void addAll(int[] values) {
    for (int value : values) {
      add(value);
    }
  }
}
