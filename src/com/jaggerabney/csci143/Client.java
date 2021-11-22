package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week8.practiceit.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(3, 7, 3, -1, 2, 3, 7, 2, 15, 15);
    List<Integer> list2 = Arrays.asList(-5, 15, 2, -1, 7, 15, 36);

    System.out.println(PracticeIt.countCommon(list1, list2));
  }
}