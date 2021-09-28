package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week1.*;

public class Client {
    public static void main(String[] args) {
        MyInteger mi1 = new MyInteger(2);
        MyInteger mi2 = new MyInteger(3);
        System.out.println(mi1.isEven());
        System.out.println(mi2.isEven());
    }
}