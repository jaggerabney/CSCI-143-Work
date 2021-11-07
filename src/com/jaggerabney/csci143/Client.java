package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.practiceit.*;

public class Client {
  public static void main(String[] args) {
    Queue<Integer> queue1 = new LinkedList<>(Arrays.asList(3, 8, 17, 9, 17, 8, 3));
    Queue<Integer> queue2 = new LinkedList<>(Arrays.asList(3, 8, 17, 9, 9, 17, 8, 3));

    System.out.println(PracticeIt.isPalindrome(queue1));
    System.out.println(PracticeIt.isPalindrome(queue2));
  }
}