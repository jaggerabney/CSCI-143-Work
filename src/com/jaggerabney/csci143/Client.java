package com.jaggerabney.csci143;

import java.util.Arrays;

import com.jaggerabney.csci143.week5.practiceit.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(7, 30, 8, 22, 6, 1, 14));
    System.out.println(PracticeIt.maxSum(list, 19));
  }
}