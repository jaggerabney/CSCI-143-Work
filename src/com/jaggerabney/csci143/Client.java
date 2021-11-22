package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week8.practiceit.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> list2 = Arrays.asList(6, 7, 8, 9, 10, 11, 12);

    System.out.println(PracticeIt.alternate(list1, list2));
  }
}