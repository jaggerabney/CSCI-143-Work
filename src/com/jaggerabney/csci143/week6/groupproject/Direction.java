package com.jaggerabney.csci143.week6.groupproject;

public enum Direction {
  NORTH(-1, 0), NORTHEAST(-1, 1), EAST(0, 1), SOUTHEAST(1, 1), SOUTH(1, 0), SOUTHWEST(1, -1), WEST(0, -1),
  NORTHWEST(-1, -1);

  private final int rowChange;
  private final int colChange;

  private Direction(int rowChange, int colChange) {
    this.rowChange = rowChange;
    this.colChange = colChange;
  }

  public int rowChange() {
    return rowChange;
  }

  public int colChange() {
    return colChange;
  }
}
