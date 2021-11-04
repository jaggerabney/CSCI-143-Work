package com.jaggerabney.csci143.week6.practiceit;

import java.util.*;

public class PracticeIt {
  public static void splitStack(Stack<Integer> stack) {
    Queue<Integer> queue = new LinkedList<Integer>();

    while (!stack.isEmpty()) {
      queue.add(stack.pop());
    }

    for (int i = 0; i < queue.size(); i++) {
      if (queue.peek() < 0) { // if head is negative
        stack.push(queue.remove()); // remove from queue, add to stack
        i--;
      } else { // if head is positive
        queue.add(queue.remove()); // move to back of queue
      }
    }
    stack.addAll(queue);
  }

  public static void stutter(Stack<Integer> stack) {
    Queue<Integer> queue = new LinkedList<>();
    int currentElement;

    Collections.reverse(stack);
    while (!stack.isEmpty()) {
      queue.add(stack.pop());
    }
    while (!queue.isEmpty()) {
      currentElement = queue.remove();
      stack.addAll(Arrays.asList(currentElement, currentElement));
    }
  }
}
