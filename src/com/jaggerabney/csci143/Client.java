package com.jaggerabney.csci143;

import java.util.*;
import com.jaggerabney.csci143.week6.practiceit.*;

public class Client {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.addAll(Arrays.asList(-4, -8, 7, 3, -5, 2));

    System.out.println("Before: " + stack);
    PracticeIt.splitStack(stack);
    System.out.println("After: " + stack);
  }
}