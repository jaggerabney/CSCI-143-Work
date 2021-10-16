package com.jaggerabney.csci143.week2.groupproject;

public class Turtle implements Critter {
  private Movement movementInfo;

  public Turtle() {
    this.movementInfo = new Movement(5, Critter.SOUTH);
  }

  @Override
  public char getChar() {
    return 'T';
  }

  @Override
  public int getMove(CritterInfo info) {
    return movementInfo.step();
  }

  class Movement {
    public int defaultSteps, stepsToTurn, lastMoveDirection;

    public Movement(int defaultSteps, int lastMoveDirection) {
      this.defaultSteps = defaultSteps;
      this.stepsToTurn = defaultSteps;
      this.lastMoveDirection = lastMoveDirection;
    }

    public int step() {
      if (stepsToTurn <= 0) {
        stepsToTurn = defaultSteps;
        lastMoveDirection = turn();
      }

      stepsToTurn--;
      return lastMoveDirection;
    }

    public int turn() {
      switch (lastMoveDirection) {
        case Critter.SOUTH:
          return Critter.WEST;
        case Critter.WEST:
          return Critter.NORTH;
        case Critter.NORTH:
          return Critter.EAST;
        case Critter.EAST:
          return Critter.SOUTH;
        default:
          return Critter.WEST; // just in case lastMoveDirection is invalid
      }
    }
  }
}
