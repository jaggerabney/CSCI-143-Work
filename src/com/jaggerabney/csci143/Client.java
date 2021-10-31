package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week5.practiceit.*;

public class Client {
  public static void main(String[] args) {
    String stringToSearch = "Barack Obama";
    String stringToFind = "ck";
    System.out.println(PracticeIt.indexOf(stringToSearch, stringToFind));
  }
}