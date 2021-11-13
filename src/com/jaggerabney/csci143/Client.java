package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week7.assignment.*;

public class Client {
  public static void main(String[] args) {
    LinkedIntList lil = new LinkedIntList();
    lil.add(34);
    lil.add(50);
    lil.add(22);
    System.out.println(lil.contains(50));
    System.out.println(lil.contains(1));
  }
}