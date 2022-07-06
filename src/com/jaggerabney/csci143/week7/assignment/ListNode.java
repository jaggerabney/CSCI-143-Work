package com.jaggerabney.csci143.week7.assignment;

public class ListNode {
  public int data;
  public ListNode next;

  public ListNode(int data) {
    this(data, null);
  }

  public ListNode(int data, ListNode next) {
    this.data = data;
    this.next = next;
  }
}
