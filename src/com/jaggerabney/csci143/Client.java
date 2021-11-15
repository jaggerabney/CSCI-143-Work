package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week7.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt pi = new PracticeIt(new int[] { 3, 9, 4, 2, 3, 8, 17, 4, 3, 18 });

    System.out.println(pi);
    pi.removeAll(3);
    System.out.println(pi);
  }
}