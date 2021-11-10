package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.practiceit.PracticeIt;

public class Client {
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(10, 50, 19, 54, 30, 67));

    System.out.println(queue);
    PracticeIt.mirrorHalves(queue);
    System.out.println(queue);
  }
}