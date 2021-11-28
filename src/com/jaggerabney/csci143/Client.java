package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree = new PracticeIt("[2 [8 [7 [4] [1 null [3]]] null] [9 [6 null [0 [4] [5]]] null]]");

    System.out.println(tree);
    tree.tighten();
    System.out.println(tree);
  }
}