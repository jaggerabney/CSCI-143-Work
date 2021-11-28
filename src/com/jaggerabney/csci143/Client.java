package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree = new PracticeIt("[-9 [3 [0] null] [15 [12 [6] [-3]] [24]]]");

    System.out.println(tree);
    tree.doublePositives();
    System.out.println(tree);
  }
}