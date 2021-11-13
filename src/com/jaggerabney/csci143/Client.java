package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.practiceit.PracticeIt;

public class Client {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.addAll(Arrays.asList(27, 5, 42, -11, 0, 19));

    System.out.println(stack);
    PracticeIt.maxToTop(stack);
    System.out.println(stack);
  }
}