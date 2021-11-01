package com.jaggerabney.csci143;

import java.util.Arrays;

import com.jaggerabney.csci143.week5.practiceit.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>(Arrays.asList("Janet", "Robert", "Morgan", "Char"));
    PracticeIt.subsets(list);
  }
}