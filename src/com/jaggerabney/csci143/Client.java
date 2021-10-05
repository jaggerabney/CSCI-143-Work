package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week2.projects.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<Integer>();

    System.out.print("Enter ten numbers: ");
    for (int i = 0; i < 10; i++) {
      list.add(input.nextInt());
    }
    Project1.removeDuplicate(list);

    System.out.print("\nThe distinct integers are: ");
    for (int num : list) {
      System.out.print(num + " ");
    }
    input.close();
  }
}