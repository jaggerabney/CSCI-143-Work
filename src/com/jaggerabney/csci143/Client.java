package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.practiceit.PracticeIt;

public class Client {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.addAll(Arrays.asList(4, 20, 15, 15, 8, 5, 7, 12, 3, 10, 5, 0));

    System.out.println(stack);
    PracticeIt.expunge(stack);
    System.out.println(stack);
  }
}