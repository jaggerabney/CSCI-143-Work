package com.jaggerabney.csci143.week6.groupproject;

// enum that represents the eight cardinal directions,
// and how you'd have to manipulate the row and column of 
// a Space object to move in that direction
public enum Direction {
  NORTH(-1, 0), NORTHEAST(-1, 1), EAST(0, 1), SOUTHEAST(1, 1), SOUTH(1, 0), SOUTHWEST(1, -1), WEST(0, -1),
  NORTHWEST(-1, -1);

  // fields, constructors, and getters
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

  // method that returns the next Direction in the values array
  // nextEnumOrdinalPosition is modulo'd for the case when it's the
  // last element in the array; in that case, the modulo reduces it
  // back to 0, i.e. the index of the first Direction
  public Direction turnClockwise() {
    int nextEnumOrdinalPosition = (this.ordinal() + 1) % values().length;

    return values()[nextEnumOrdinalPosition];
  }

  // toString override
  @Override
  public String toString() {
    String name = this.name();

    return name.substring(0, 1) + name.substring(1).toLowerCase();
  }
}
