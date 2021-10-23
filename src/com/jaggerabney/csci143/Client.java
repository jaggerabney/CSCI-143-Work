package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week4.practiceit.*;

public class Client {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16));
    PracticeIt.removeInRange(list, 0, 5, 13);
    System.out.println(list);
  }
}