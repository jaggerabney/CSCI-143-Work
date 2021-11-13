package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week7.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt pi = new PracticeIt(new int[] { 1, 1, 1, 3, 3, 6, 9, 15, 15, 23, 23, 23, 40, 40 });
    System.out.println(pi.countDuplicates());
  }
}