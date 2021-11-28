package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree = new PracticeIt("[42]");

    System.out.println(tree);
    tree.evenLevels();
    System.out.println(tree);
  }
}