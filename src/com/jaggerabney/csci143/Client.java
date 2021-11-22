package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week8.practiceit.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    Set<String> set = new HashSet<>(Arrays.asList("foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"));

    System.out.println(set);
    PracticeIt.removeEvenLength(set);
    System.out.println(set);
  }
}