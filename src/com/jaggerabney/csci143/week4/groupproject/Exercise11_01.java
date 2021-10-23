package com.jaggerabney.csci143.week4.groupproject;

public class Exercise11_01 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(1, 1.5, 1);
        triangle.setColor("yellow");
        triangle.setFilled(true);

        System.out.println(triangle);
        System.out.println("The area is " + triangle.getArea());
        System.out.println("The perimeter is " + triangle.getPerimeter());
        System.out.println("The triangle is filled: " + triangle.isFilled());
        System.out.println("The triangle's color: " + triangle.getColor());
    }
}
