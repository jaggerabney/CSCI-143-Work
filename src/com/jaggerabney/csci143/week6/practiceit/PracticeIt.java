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

  public static boolean isOdd(int value) {
    return value % 2 != 0;
  }

  public static void reverseHalf(Queue<Integer> queue) {
    Stack<Integer> storage = new Stack<>();
    int queueLength = queue.size();
    int currentElement;

    for (int i = 0; i < queueLength; i++) {
      if (isOdd(i)) {
        currentElement = queue.poll();

        storage.push(currentElement);
      } else {
        queue.offer(queue.poll());
      }
    }

    queueLength = queue.size();
    for (int i = 0; i < queueLength; i++) {
      queue.offer(queue.poll());
      if (!storage.isEmpty()) {
        queue.offer(storage.pop());
      }
    }
  }

  public static boolean isPalindrome(Queue<Integer> queue) {
    Stack<Integer> storage = new Stack<>();
    int queueLength = queue.size();
    boolean isPalindrome = true;
    int currentElement;

    for (int i = 0; i < queueLength; i++) {
      currentElement = queue.poll();

      queue.offer(currentElement);
      storage.push(currentElement);
    }

    for (int i = 0; i < queueLength; i++) {
      currentElement = queue.poll();

      if (currentElement != storage.pop()) {
        isPalindrome = false;
      }

      queue.offer(currentElement);
    }

    return isPalindrome;
  }

  public static void switchPairs(Stack<Integer> stack) {
    Queue<Integer> storage = new LinkedList<>();
    boolean stackLengthIsOdd = stack.size() % 2 != 0;
    int oddStackTopElement = 0, currentElement = 0;

    if (stackLengthIsOdd) {
      oddStackTopElement = stack.pop();
    }

    Collections.reverse(stack);
    while (!stack.isEmpty()) {
      currentElement = stack.pop();
      storage.offer(stack.pop());
      storage.offer(currentElement);
    }
    while (!storage.isEmpty()) {
      stack.push(storage.poll());
    }

    if (stackLengthIsOdd) {
      stack.push(oddStackTopElement);
    }
  }

  public static boolean isConsecutive(Stack<Integer> stack) {
    Queue<Integer> storage = new LinkedList<>();
    int currentElement = 0, lastElement = 0;
    boolean isConsecutive = true;

    // start process
    lastElement = stack.pop();
    storage.offer(lastElement);

    while (!stack.isEmpty()) {
      currentElement = stack.pop();
      storage.offer(currentElement);

      if (currentElement + 1 != lastElement) {
        isConsecutive = false;
      }

      lastElement = currentElement;
    }

    while (!storage.isEmpty()) {
      stack.push(storage.poll());
    }
    Collections.reverse(stack);
    return isConsecutive;
  }

  public static void reorder(Queue<Integer> queue) {
    Stack<Integer> storage = new Stack<>();
    int highestElement, queueLength;

    while (!queue.isEmpty()) {
      queueLength = queue.size();
      highestElement = queue.peek();

      for (int i = 0; i < queueLength; i++) {
        if (highestElement < queue.peek()) {
          highestElement = queue.peek();
        }

        queue.offer(queue.poll());
      }

      for (int i = 0; i < queueLength; i++) {
        if (queue.peek() == highestElement) {
          storage.push(queue.poll());
        } else {
          queue.offer(queue.poll());
        }
      }
    }

    Collections.reverse(storage);
    queue.addAll(storage);
  }

  public static void shift(Stack<Integer> stack, int shift) {
    Queue<Integer> storage = new LinkedList<>();
    storage.addAll(stack.subList(shift, stack.size()));
    stack.removeAll(storage);

    Collections.reverse(stack);
    storage.addAll(stack);

    stack.clear();
    stack.addAll(storage);
  }

  public static void expunge(Stack<Integer> stack) {
    Stack<Integer> storage = new Stack<>();
    int currentElement, elementAbove;

    if (stack.size() <= 1) {
      return;
    }

    // start process
    elementAbove = stack.pop();
    storage.add(elementAbove);

    while (!stack.isEmpty()) {
      currentElement = stack.pop();

      if (currentElement >= elementAbove && currentElement >= storage.peek()) {
        storage.push(currentElement);
      }

      elementAbove = currentElement;
    }

    Collections.reverse(storage);
    stack.addAll(storage);
  }

  public static void reverseFirstK(int k, Queue<Integer> queue) {
    if (k <= 0) {
      return;
    } else if (queue == null || queue.size() < k) {
      throw new IllegalArgumentException();
    }

    Stack<Integer> storage = new Stack<>();

    for (int i = 0; i < k; i++) {
      storage.push(queue.poll());
    }
    Collections.reverse(storage);
    storage.addAll(queue);

    queue.clear();
    queue.addAll(storage);
  }

  public static boolean isSorted(Stack<Integer> stack) {
    Stack<Integer> storage = new Stack<>();
    int currentElement, elementAbove;
    boolean isSorted = true;

    if (stack.size() <= 1) {
      return isSorted;
    }

    // start process
    elementAbove = stack.pop();
    storage.add(elementAbove);

    while (!stack.isEmpty()) {
      currentElement = stack.pop();
      storage.add(currentElement);

      if (currentElement < elementAbove) {
        isSorted = false;
      }

      elementAbove = currentElement;
    }

    Collections.reverse(storage);
    stack.addAll(storage);

    return isSorted;
  }

  public static void mirror(Stack<Integer> stack) {
    if (stack == null)
      throw new IllegalArgumentException("stack cannot be null");

    Queue<Integer> storage = new LinkedList<>();

    while (!stack.isEmpty()) {
      storage.offer(stack.pop());
    }
    for (int i = 0; i < storage.size(); i++) {
      stack.push(storage.peek());
      storage.offer(storage.poll());
    }
    Collections.reverse(stack);
    stack.addAll(storage);
  }

  public static void compressDuplicates(Stack<Integer> stack) {
    Queue<Integer> storage = new LinkedList<>();
    int currentElement, numOccurances;

    while (!stack.isEmpty()) {
      currentElement = stack.pop();
      numOccurances = 1;

      while (!stack.isEmpty() && stack.peek() == currentElement) {
        stack.pop();
        numOccurances++;
      }

      storage.offer(currentElement);
      storage.offer(numOccurances);
    }

    stack.addAll(storage);
    Collections.reverse(stack);
  }

  public static void mirrorHalves(Queue<Integer> queue) {
    if (queue == null) {
      throw new IllegalArgumentException("queue cannot be null");
    } else if (queue.size() % 2 != 0) {
      throw new IllegalArgumentException("queue must be of even length");
    }

    Stack<Integer> storage = new Stack<>();
    int halfQueueLength = queue.size() / 2;

    mirrorHalvesHelper(queue, storage, halfQueueLength);
    mirrorHalvesHelper(queue, storage, halfQueueLength);
  }

  private static void mirrorHalvesHelper(Queue<Integer> queue, Stack<Integer> storage, int limit) {
    int currentElement;

    for (int i = 0; i < limit; i++) {
      currentElement = queue.poll();

      storage.push(currentElement);
      queue.offer(currentElement);
    }

    while (!storage.isEmpty()) {
      queue.offer(storage.pop());
    }
  }

  public static int removeMin(Stack<Integer> stack) {
    Queue<Integer> storage = new LinkedList<>();
    int lowestElement, currentElement;
    storage.addAll(stack);
    stack.clear();

    lowestElement = storage.peek();
    for (int i = 0; i < storage.size(); i++) {
      currentElement = storage.peek();

      if (currentElement < lowestElement) {
        lowestElement = currentElement;
      }

      storage.offer(storage.poll());
    }

    for (int i = 0; i < storage.size(); i++) {
      currentElement = storage.peek();

      if (currentElement == lowestElement) {
        storage.poll();
        i--;
        continue;
      }

      storage.offer(storage.poll());
    }

    stack.addAll(storage);
    return lowestElement;
  }
}
