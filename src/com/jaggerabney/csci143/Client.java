package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.practiceit.PracticeIt;

public class Client {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.addAll(Arrays.asList(2, 2, 2, 2, 2, -5, -5, 3, 3, 3, 3, 4, 4, 1, 0, 17, 17));

    System.out.println(stack);
    PracticeIt.compressDuplicates(stack);
    System.out.println(stack);
  }
}