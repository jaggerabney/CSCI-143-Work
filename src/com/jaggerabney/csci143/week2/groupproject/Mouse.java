package com.jaggerabney.csci143.week2.groupproject;

// File: Mouse.java
// Author: Jagger Abney
// Purpose: to define a Critter that constantly moves northwest

public class Mouse implements Critter {
  // keeps track of the last direction the Mouse moved in
  private int lastMoveDirection;

  public Mouse() {
    // first move is to the West
    this.lastMoveDirection = Critter.WEST;
  }

  @Override
  public char getChar() {
    return 'M';
  }

  @Override
  public int getMove(CritterInfo info) {
    // moves North if last direction was West, and vice versa
    // this results in a northwest zig-zag pattern
    if (lastMoveDirection == Critter.WEST) {
      lastMoveDirection = Critter.NORTH;
      return Critter.NORTH;
    } else {
      lastMoveDirection = Critter.WEST;
      return Critter.WEST;
    }
  }
}
