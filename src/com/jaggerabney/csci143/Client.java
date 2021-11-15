package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week7.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt pi = new PracticeIt(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 });

    System.out.println(pi);
    pi.shift();
    System.out.println(pi);
  }
}