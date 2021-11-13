package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week7.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt pi = new PracticeIt(new int[] { 1, 8, 19, 4, 17 });

    System.out.println(pi);
    pi.stretch(3);
    System.out.println(pi);
  }
}