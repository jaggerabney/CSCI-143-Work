package com.jaggerabney.csci143.week2.groupproject;

public class Mouse implements Critter {
  private int lastMoveDirection;

  public Mouse() {
    this.lastMoveDirection = Critter.WEST;
  }

  @Override
  public char getChar() {
    return 'M';
  }

  @Override
  public int getMove(CritterInfo info) {
    if (lastMoveDirection == Critter.WEST) {
      lastMoveDirection = Critter.NORTH;
      return Critter.NORTH;
    } else {
      lastMoveDirection = Critter.WEST;
      return Critter.WEST;
    }
  }
}
