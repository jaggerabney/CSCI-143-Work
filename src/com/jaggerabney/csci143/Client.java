package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week7.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt pi = new PracticeIt(new int[] { 8, 17, 2, 4 });
    PracticeIt pi2 = new PracticeIt(new int[] { 1, 2, 3 });

    System.out.println(pi);
    pi.transferFrom(pi2);
    System.out.println(pi);
  }
}