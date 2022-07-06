package com.jaggerabney.csci143.week6.groupproject;

// Helper class that represents a space on a chessboard
public class Space {
  // fields are public & final for easier access
  // instead of reassigning them, make a new Space object!
  public final int row, col;

  public Space() {
    this(0, 0);
  }

  public Space(int row, int col) {
    this.row = row;
    this.col = col;
  }

  @Override
  public String toString() {
    return "(" + row + ", " + col + ")";
  }
}
