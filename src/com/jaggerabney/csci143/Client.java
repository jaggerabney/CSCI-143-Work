package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week5.projects.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    int m, n;
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the first number: ");
    m = scanner.nextInt();
    System.out.print("Enter the second number: ");
    n = scanner.nextInt();

    System.out.println("The GCD of " + m + " and " + n + " is " + Exercise18_03.gcd(m, n));
    scanner.close();
  }
}