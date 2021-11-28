package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree = new PracticeIt("[67 [80 [16] [21 [45] [33]]] [52 [99 null [67]] null]]");

    System.out.println(tree);
    tree.makePerfect();
    System.out.println(tree);
  }
}