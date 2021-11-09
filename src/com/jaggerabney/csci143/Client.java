package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.practiceit.PracticeIt;

public class Client {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.addAll(Arrays.asList(3, 4, 5, 12, 6, 7, 8, 9, 10));

    System.out.println(stack);
    System.out.println(PracticeIt.isConsecutive(stack));
    System.out.println(stack);
  }
}