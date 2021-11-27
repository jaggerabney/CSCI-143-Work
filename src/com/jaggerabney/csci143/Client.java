package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree = new PracticeIt(
        "[0 [4 [3 [4 [1] null] null] null] [6 [0 [3 null [9]] [8]] [1 null [5 [2] [7]]]]]");
    System.out.println(tree.countEmpty());
  }
}