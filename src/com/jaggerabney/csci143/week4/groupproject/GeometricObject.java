package com.jaggerabney.csci143.week4.groupproject;

import java.util.*;

public abstract class GeometricObject {
    private String color;
    private boolean filled;
    private Date dateCreated;

    // Default constructor
    protected GeometricObject() {
        this("white", false);
    }

    // Construct a geometric object
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    // Getter method for color
    public String getColor() {
        return color;
    }

    // Setter method for color
    public void setColor(String color) {
        this.color = color;
    }

    // Getter method for filled
    // Since filled is a boolean, the method is named isFilled
    public boolean isFilled() {
        return filled;
    }

    // Setter method for filled
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Getter for dateCreated
    public Date getDateCreated() {
        return dateCreated;
    }

    // Abstract method getArea
    public abstract double getArea();

    // Abstract method getPerimeter
    public abstract double getPerimeter();
}