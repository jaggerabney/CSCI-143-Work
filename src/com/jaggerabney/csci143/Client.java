package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week2.projects.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    double[] points = { -12, 0, -8.5, 10, 0, 11.4, 5.5, 7.8, 6, -5.5, 0, -7, -3.5, -5.5 };
    ConvexPolygon cp = new ConvexPolygon(points);
    System.out.println(cp.getArea());
  }
}