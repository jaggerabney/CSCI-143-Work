package com.jaggerabney.csci143.week2.projects;

import java.util.ArrayList;

public class PerfectSquare {
  public static int multiplyArrayTogether(int[] array) {
    int product = 1;

    for (int value : array) {
      product *= value;
    }

    return product;
  }

  public static int[] getOddOccurences(int[] values) {
    ArrayList<Integer> oddOccurences = new ArrayList<Integer>();

    for (int i = 0; i < values.length; i++) {
      if (oddOccurences.contains(values[i])) {
        oddOccurences.remove(oddOccurences.indexOf(values[i]));
      } else {
        oddOccurences.add(values[i]);
      }
    }

    return oddOccurences.stream().mapToInt(i -> i).toArray();
  }

  public static int[] primeFactorizationsOf(int value) {
    int divisor = 2;
    ArrayList<Integer> primeFactors = new ArrayList<Integer>();

    while (value > 1) {
      if ((double) value % (double) divisor == 0.0) {
        primeFactors.add(divisor);
        value /= divisor;
      } else {
        divisor = nextPrimeAfter(divisor);
      }
    }

    return primeFactors.stream().mapToInt(i -> i).toArray();
  }

  public static int nextPrimeAfter(int value) {
    do {
      value++;
    } while (isPrime(value) == false);

    return value;
  }

  public static boolean isPrime(int value) {
    boolean isPrime = true;

    if (value >= 2) {
      for (int i = 2; i < value; i++) {
        if (value % i == 0) { // if value is divisible by anything
          isPrime = false;
        }
      }
    } else {
      isPrime = false; // apparently 0, 1, and negative numbers are not prime
      // this else statement reflects that admittedly weird mathematic behavior
    }

    return isPrime;
  }
}
