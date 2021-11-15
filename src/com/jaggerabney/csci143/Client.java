package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week7.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt pi = new PracticeIt(new int[] { 1, 3, 2, 7 });

    System.out.println(pi);
    pi.doubleList();
    System.out.println(pi);
  }
}