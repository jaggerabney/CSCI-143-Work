package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week7.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt pi = new PracticeIt();
    pi.add(1);
    pi.add(2);
    pi.add(3);
    // pi.add(1);
    System.out.println(pi.isSorted());
  }
}