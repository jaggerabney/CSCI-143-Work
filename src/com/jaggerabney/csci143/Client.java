package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree = new PracticeIt("[2 [8 [0] null] [1 [7 [4] null] [6 null [9]]]]");
    tree.printLeaves();
  }
}