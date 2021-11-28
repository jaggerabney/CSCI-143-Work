package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree1 = new PracticeIt("[9 [6 [9] [2 [4] null]] [14 null [11]]]");
    PracticeIt tree2 = new PracticeIt("[0 [-3 [8] null] [8 [5 null [1]] [6]]]");

    System.out.println(tree1.inOrderList());
    System.out.println(tree2.inOrderList());
  }
}