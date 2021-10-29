package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week5.practiceit.*;
import com.jaggerabney.csci143.week5.projects.*;
import java.math.*;

public class Client {
  public static void main(String[] args) {
    BigInteger bi = BigIntFact.factorial(25);
    System.out.println(bi);
  }
}