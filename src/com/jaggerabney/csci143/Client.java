package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week4.assignment.*;

public class Client {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>(
        Arrays.asList("mankind", "knew", "that", "they", "couldn't", "change", "society"));
    System.out.println(ReverseFile.reverse(list));
  }
}