package com.jaggerabney.csci143.week6.classcoding;

import java.util.*;

public class Equal {
  public static boolean equal(Stack<Integer> s1, Stack<Integer> s2) {
    Stack<Integer> s3 = new Stack<>();
    int temp;

    if (s1.size() == s2.size()) {
      while (!s1.isEmpty() && !s2.isEmpty()) {
        if (s1.peek() == s2.peek()) {
          s3.push(s1.pop());
          s2.pop();
        } else {
          while (!s3.isEmpty()) {
            temp = s3.pop();
            s1.push(temp);
            s2.push(temp);
          }

          return false;
        }
      }

      while (!s3.isEmpty()) {
        temp = s3.pop();
        s1.push(temp);
        s2.push(temp);
      }

      return true;
    } else {
      return false;
    }
  }
}
