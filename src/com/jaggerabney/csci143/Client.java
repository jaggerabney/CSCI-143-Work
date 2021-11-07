package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.practiceit.*;

public class Client {
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 8, 7, 2, 9, 18, 12, 0));
    PracticeIt.reverseHalf(queue);
    System.out.println(queue);
  }
}