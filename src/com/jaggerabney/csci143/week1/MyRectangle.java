package com.jaggerabney.csci143.week1;

public class MyRectangle {
  public double width = 1;
  public double height = 1;
  
  public MyRectangle() {}
  
  public MyRectangle(double width, double height) {
      this.width = width;
      this.height = height;
  }
  
  public double getArea() {
      return width * height;
  }
  
  public double getPerimeter() {
      return 2 * (width + height);
  }
}