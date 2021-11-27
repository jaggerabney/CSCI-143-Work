package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree = new PracticeIt("[3 [5 [1] null] [2 [4 [7] null] [6]]]");
    System.out.println(tree.countLeftNodes());
  }
}