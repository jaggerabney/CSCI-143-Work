package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week2.projects.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    int[] primeFactors = PerfectSquare.primeFactorizationsOf(63);
    int[] oddOccurences = PerfectSquare.getOddOccurences(primeFactors);

    for (int occurence : oddOccurences) {
      System.out.println(occurence);
    }
  }
}