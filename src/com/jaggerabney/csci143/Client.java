package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week7.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt pi = new PracticeIt(new int[] { 8, 13, 17, 4, 9, 12, 98, 41, 7, 23, 0, 92 });

    System.out.println(pi);
    pi.removeRange(3, 8);
    System.out.println(pi);
  }
}