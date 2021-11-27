package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree = new PracticeIt("[9 [7 [3] [2 [5] null]] [6 null [4 null [2]]]]");
    System.out.println(tree.depthSum());
  }
}