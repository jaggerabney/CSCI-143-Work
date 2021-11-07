package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.classcoding.Equal;
import com.jaggerabney.csci143.week6.practiceit.*;

public class Client {
  public static void main(String[] args) {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    Stack<Integer> stack3 = new Stack<>();
    stack1.addAll(Arrays.asList(9, 14, 1, 7, 3));
    stack2.addAll(Arrays.asList(9, 14, 1, 7, 3));
    stack3.addAll(Arrays.asList(9, 14, 3, 4, 5));

    System.out.println(stack1 + ", " + stack2 + ", " + stack3);
    System.out.println("Stack 1 & 2: " + Equal.equal(stack1, stack2));
    System.out.println("Stack 1 & 3: " + Equal.equal(stack1, stack3));
    System.out.println(stack1 + ", " + stack2 + ", " + stack3);
  }
}