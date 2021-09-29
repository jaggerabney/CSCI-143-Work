package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week1.*;

public class Client {
    public static void main(String[] args) {
        RegularPolygon rp1 = new RegularPolygon();
        RegularPolygon rp2 = new RegularPolygon(6, 4);
        RegularPolygon rp3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("Polygon 1 perimeter: " + rp1.getPerimeter());
        System.out.println("Polygon 1 area: " + rp1.getArea());
        System.out.println("Polygon 2 perimeter: " + rp2.getPerimeter());
        System.out.println("Polygon 2 area: " + rp2.getArea());
        System.out.println("Polygon 3 perimeter: " + rp3.getPerimeter());
        System.out.println("Polygon 3 area: " + rp3.getArea());
    }
}