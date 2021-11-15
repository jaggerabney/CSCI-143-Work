package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week7.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt pi = new PracticeIt(new int[] { 2, 4, 18, 1, 30, -4, 5, 58, 21, 13, 19, 27 });

    System.out.println(pi);
    pi.compress(2);
    System.out.println(pi);
  }
}