package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree1 = new PracticeIt("[2 [3 [8] [7]] [1]]");
    PracticeIt tree2 = new PracticeIt("[7 [4 [9] [2]] [0 null [8]]]");

    System.out.println(tree1.isFull());
    System.out.println(tree2.isFull());
  }
}