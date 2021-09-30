package com.jaggerabney.csci143.week1;

public class Location {
  public int row, column;
  public double maxValue;

  public Location(int row, int column, double maxValue) {
    this.row = row;
    this.column = column;
    this.maxValue = maxValue;
  }

  public static Location locateLargest(double[][] a) {
    Location currentMax = new Location(0, 0, a[0][0]);

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        if (a[i][j] > currentMax.maxValue) {
          currentMax = new Location(i, j, a[i][j]);
        }
      }
    }

    return currentMax;
  }
}
