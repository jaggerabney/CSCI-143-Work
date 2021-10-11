package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week2.projects.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    int[] primeFactors = PerfectSquare.primeFactorizationsOf(225);
    for (int factor : primeFactors) {
      System.out.println(factor);
    }
  }
}