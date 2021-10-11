package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week2.projects.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int m;

    System.out.print("Enter an integer m: ");
    m = input.nextInt();

    int[] primeFactors = PerfectSquare.primeFactorizationsOf(m);
    int[] oddOccurences = PerfectSquare.getOddOccurences(primeFactors);
    int n = PerfectSquare.multiplyArrayTogether(oddOccurences);
    int mByN = m * n;

    System.out.println("The smallest number n for m x n to be a perfect square is " + n);
    System.out.println("m x n is " + mByN);
  }
}