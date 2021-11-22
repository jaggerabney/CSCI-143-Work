package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week8.practiceit.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("banana", "bends", "i", "mend", "sandy");

    System.out.println(PracticeIt.pairCounts(list));
  }
}