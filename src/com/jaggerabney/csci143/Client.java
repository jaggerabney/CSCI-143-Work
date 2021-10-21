package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week4.practiceit.*;

public class Client {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.addAll(Arrays.asList(new String[] { "four", "score", "and", "seven", "years", "ago" }));
    System.out.println(list);
    PracticeIt.doubleList(list);
    System.out.println(list);
  }
}