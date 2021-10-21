package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week4.assignment.ReverseFile;

public class Client {
  public static void main(String[] args) {
    try {
      ArrayList<String> text = ReverseFile.readFile("mobydick.txt");
      for (String line : text) {
        System.out.println(line);
      }
    } catch (Exception e) {
      System.out.println("file machine broke");
    }
  }
}