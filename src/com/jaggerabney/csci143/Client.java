package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.practiceit.PracticeIt;

public class Client {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.addAll(Arrays.asList(2, 8, 3, 19, 7, 3, 2, 3, 2, 7, 12, -8, 4));

    System.out.println(stack);
    PracticeIt.removeMin(stack);
    System.out.println(stack);
  }
}