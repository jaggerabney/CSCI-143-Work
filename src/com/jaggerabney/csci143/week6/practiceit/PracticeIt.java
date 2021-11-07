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

  public static Stack<Integer> copyStack(Stack<Integer> stack) {
    Queue<Integer> queue = new LinkedList<>();
    Stack<Integer> copiedStack = new Stack<Integer>();
    int currentElement;

    Collections.reverse(stack);
    while (!stack.isEmpty()) {
      queue.add(stack.pop());
    }
    while (!queue.isEmpty()) {
      currentElement = queue.remove();
      stack.push(currentElement);
      copiedStack.push(currentElement);
    }

    return copiedStack;
  }

  public static void collapse(Stack<Integer> stack) {
    Queue<Integer> queue = new LinkedList<>();
    int oddElement = 0;
    boolean oddInLength = false;

    if (stack.size() % 2 != 0) { // stack is odd in length
      oddElement = stack.pop();
      oddInLength = true;
    }

    Collections.reverse(stack);
    while (stack.size() >= 2) {
      queue.add(stack.pop() + stack.pop());
    }
    while (!queue.isEmpty()) {
      stack.push(queue.remove());
    }

    if (oddInLength) {
      stack.push(oddElement);
    }
  }

  public static boolean equals(Stack<Integer> first, Stack<Integer> second) {
    Stack<Integer> storage = new Stack<>();
    int currentElementFirst, currentElementSecond, currentElementStorage;

    if (first.size() == second.size()) {
      while (!first.isEmpty() && !second.isEmpty()) {
        currentElementFirst = first.peek();
        currentElementSecond = second.peek();

        if (currentElementFirst == currentElementSecond) {
          first.pop();
          second.pop();
          storage.push(currentElementFirst);
        } else {
          if (storage.size() > 0) {
            while (!storage.isEmpty()) {
              currentElementStorage = storage.pop();
              first.push(currentElementStorage);
              second.push(currentElementStorage);
            }

            return false;
          }
        }
      }

      while (!storage.isEmpty()) {
        currentElementStorage = storage.pop();
        first.push(currentElementStorage);
        second.push(currentElementStorage);
      }

      return true;
    } else {
      return false;
    }
  }

  public static void rearrange(Queue<Integer> queue) {
    Stack<Integer> storage = new Stack<>();
    int queueLength = queue.size();
    int currentElement;

    for (int i = 0; i < queueLength; i++) {
      currentElement = queue.peek();

      if (isEven(currentElement)) {
        queue.offer(queue.poll());
      } else {
        storage.push(queue.poll());
      }
    }
    Collections.reverse(storage);
    while (!storage.isEmpty()) {
      queue.offer(storage.pop());
    }
  }

  private static boolean isEven(int value) {
    return value % 2 == 0;
  }

  private static boolean isOdd(int value) {
    return value % 2 != 0;
  }
}
