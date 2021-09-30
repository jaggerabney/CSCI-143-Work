package com.jaggerabney.csci143;

import com.jaggerabney.csci143.week1.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String temp;
        String[] tempArray;
        int rows, columns;
        Location maxValue;

        System.out.print("Enter the number of rows and columns: ");
        temp = input.nextLine();
        tempArray = temp.split(" ");
        rows = Integer.parseInt(tempArray[0]);
        columns = Integer.parseInt(tempArray[1]);

        double[][] values = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            temp = input.nextLine();
            tempArray = temp.split(" ");

            for (int j = 0; j < columns; j++) {
                values[i][j] = Double.parseDouble(tempArray[j]);
            }
        }

        maxValue = Location.locateLargest(values);
        System.out.println("The largest element is " + maxValue.maxValue + 
            ", located at (" + maxValue.row + ", " + maxValue.column + ")");
    }
}