package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week8.practiceit.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 7, 3, -1, 2, 3, 7, 2, 15, 15));

    System.out.println(PracticeIt.countUnique(list));
  }
}