package com.jaggerabney.csci143.week2.projects;

public class ConvexPolygon {
  private double[] points;

  public ConvexPolygon() {
    this(new double[] { 1.0, 1.0, 1.0, 0.0, 0.0, 0.0 });
  }

  public ConvexPolygon(double[] points) {
    this.points = points;
  }

  private double determinant(Point p1, Point p2) {
    return ((p1.x * p2.y) - (p2.x * p1.y));
  }

  private Point[] initPointsArray(double[] values) {
    if (values != null && values.length >= 6 && values.length % 2 == 0) {
      Point[] pointsArray = new Point[values.length / 2];

      for (int i = 0; i < values.length - 1; i += 2) {
        pointsArray[i / 2] = new Point(points[i], points[i + 1]);
      }

      return pointsArray;
    }

    return null;
  }

  public double getArea() {
    double sum = 0;

    if (points != null && points.length >= 6 && points.length % 2 == 0) {
      Point[] pointsAsPoints = initPointsArray(points);

      for (int i = pointsAsPoints.length - 1; i > 0; i--) {
        sum += determinant(pointsAsPoints[i], pointsAsPoints[i - 1]);
      }
      sum += determinant(pointsAsPoints[0], pointsAsPoints[pointsAsPoints.length - 1]);

    }

    return sum / 2;
  }
}

class Point {
  public final double x, y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}