package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree = new PracticeIt("[17 [83 [19 null [48]] null] [6 null [87 [75] null]]]");

    System.out.println(tree);
    tree.completeToLevel(3);
    System.out.println(tree);
  }
}