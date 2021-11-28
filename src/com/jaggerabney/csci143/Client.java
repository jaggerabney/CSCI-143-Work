package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree = new PracticeIt("[7 [3 [9] [2]] [9 null [0]]]");

    System.out.println(tree);
    tree.numberNodes();
    System.out.println(tree);
  }
}