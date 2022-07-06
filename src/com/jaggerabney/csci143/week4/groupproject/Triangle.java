package com.jaggerabney.csci143.week4.groupproject;

public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    // No argument constructor which Initializes a deafault Triangle.
    public Triangle() {
        this(0.0, 0.0, 0.0);
    }

    // Constructor which takes side values from user.
    public Triangle(double s1, double s2, double s3) {
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }

    // getters for sides 1, 2, and 3
    public double getSide1() {
        return this.side1;
    }

    public double getSide2() {
        return this.side2;
    }

    public double getSide3() {
        return this.side3;
    }

    @Override
    public double getArea() {
        // area is found by using Heron's formula:
        // sqrt(s(s - a)(s - b)(s - c))
        // where s is the semiperimeter of the triangle ((a + b + c) / 2),
        // and a, b, and c are the three sides of the triangle
        double s = (side1 + side2 + side3) / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        // perimeter is found by summing sides up
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

}
