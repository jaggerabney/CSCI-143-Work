package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week1.*;

public class Client {
    public static void main(String[] args) {
        MyRectangle r1 = new MyRectangle(4, 40);
        MyRectangle r2 = new MyRectangle(3.5, 35.9);
        
        System.out.println("The area of a rectangle with width " + r1.width + " and height " + r1.height + " is " + r1.getArea());
        System.out.println("The perimeter of a rectangle is " + r1.getPerimeter());
        System.out.println("The area of a rectangle with width " + r2.width + " and height " + r2.height + " is " + r2.getArea());
        System.out.println("The perimeter of a rectangle is " + r2.getPerimeter());
    }
}