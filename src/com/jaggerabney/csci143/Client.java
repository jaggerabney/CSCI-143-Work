package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree = new PracticeIt("[7 [3 [1] [4]] [9 [6] [8 null [0]]]]");

    System.out.println(tree);
    tree.removeLeaves();
    System.out.println(tree);
  }
}