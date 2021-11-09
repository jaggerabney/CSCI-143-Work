package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.practiceit.PracticeIt;

public class Client {
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(1, 2, -2, 4, -5, 8, -8, 12, -15, 23));

    System.out.println(queue.peek());
    System.out.println(queue);
    PracticeIt.reorder(queue);
    System.out.println(queue);
  }
}