package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week6.groupproject.*;

public class Client {
  public static void main(String[] args) {
    EightQueen eq = new EightQueen();
    eq.placeQueens();
    System.out.println(eq);
  }
}