package com.jaggerabney.csci143;

import java.util.*;

import com.jaggerabney.csci143.week6.groupproject.*;

public class Client {
  public static void main(String[] args) {
    Direction dir = Direction.NORTH;

    do {
      System.out.println(dir);
      dir = dir.turnClockwise();
    } while (!dir.equals(Direction.NORTH));
  }
}