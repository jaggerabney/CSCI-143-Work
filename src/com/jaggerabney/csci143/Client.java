package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week7.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt pi = new PracticeIt(new int[] { 3, 7, 4, 9, 8, 12 });

    System.out.println(pi);
    pi.switchPairs();
    System.out.println(pi);
  }
}