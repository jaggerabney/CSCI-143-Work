package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week7.practiceit.*;

public class Client {
  public static void main(String[] args) {
    PracticeIt pi = new PracticeIt(new int[] { 10, 20, 30, 40, 50 });
    System.out.println(pi.deleteBack());
  }
}