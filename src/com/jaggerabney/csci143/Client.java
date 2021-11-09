package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.practiceit.PracticeIt;

public class Client {
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90));

    System.out.println(queue);
    PracticeIt.reverseFirstK(4, queue);
    System.out.println(queue);
  }
}