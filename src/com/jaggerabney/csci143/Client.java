package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week9.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt tree = new PracticeIt("[12 [19 [11] [14 [10] null]] [93 null [15]]]");
    tree.printLevel(4);
  }
}