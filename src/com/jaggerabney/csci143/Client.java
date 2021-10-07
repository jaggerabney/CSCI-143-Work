package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week2.projects.*;
import java.util.*;

public class Client {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numPoints;
    double[] points;

    System.out.println("Enter the number of points: ");
    numPoints = input.nextInt();
    points = new double[numPoints * 2];
    System.out.println("Enter the coordinates of the points: ");
    for (int i = 0; i < points.length; i++) {
      points[i] = input.nextDouble();
    }

    ConvexPolygon cp = new ConvexPolygon(points);
    System.out.println("The total area is " + cp.getArea());
  }
}