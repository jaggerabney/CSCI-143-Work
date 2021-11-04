package com.jaggerabney.csci143;

import java.util.*;
import com.jaggerabney.csci143.week6.practiceit.*;

public class Client {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.addAll(Arrays.asList(9, 14, 1, 7, 3));

    System.out.println(stack);
    PracticeIt.stutter(stack);
    System.out.println(stack);
  }
}