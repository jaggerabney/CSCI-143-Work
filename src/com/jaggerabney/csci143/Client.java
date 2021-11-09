package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.practiceit.PracticeIt;

public class Client {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.addAll(Arrays.asList(3, 8, 17, 9, 99, 9, 17, 8, 3, 1, 2, 3, 4, 14));

    System.out.println(stack);
    PracticeIt.switchPairs(stack);
    System.out.println(stack);
  }
}