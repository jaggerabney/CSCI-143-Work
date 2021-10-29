package com.jaggerabney.csci143.week5.projects;

import java.math.BigInteger;

public class BigIntFact {
  public static BigInteger factorial(int times) {
    if (times == 0) {
      return new BigInteger("1");
    } else {
      return new BigInteger(String.valueOf(times)).multiply(factorial(times - 1));
    }
  }
}
