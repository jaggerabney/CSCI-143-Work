package com.jaggerabney.csci143.week2.groupproject;

// File: Turtle.java
// Author: Jagger Abney
// Purpose: to define a Critter that moves in a clockwise, 5-step box

import java.util.Random;

public class Turtle implements Critter {
  private Movement movementInfo;

  public Turtle() {
    this.movementInfo = new Movement(5);
  }

  @Override
  public char getChar() {
    return 'T';
  }

  @Override
  public int getMove(CritterInfo info) {
    // which direction the Turtle moves in is handled by its Movement class
    return movementInfo.step();
  }

  private class Movement {
    // fields for the amount of steps to take before turning,
    // how many steps have been taken before the next turn,
    // and the last direction turned to
    public int defaultSteps, stepsToTurn, lastMoveDirection;

    public Movement(int defaultSteps) {
      this.defaultSteps = defaultSteps;
      this.stepsToTurn = defaultSteps;
      this.lastMoveDirection = randomDirection();
    }

    public int step() {
      if (stepsToTurn <= 0) {
        // if there are no more steps to take before the turn, reset the
        // Turtle's steps to the default (i.e. 5) and turn
        stepsToTurn = defaultSteps;
        lastMoveDirection = turn();
      }

      // finally, subtract steps taken and return the direction to move in
      stepsToTurn--;
      return lastMoveDirection;
    }

    public int randomDirection() {
      // generates a random direction -- used in the Turtle's initialization
      int[] possibilities = new int[] { Critter.NORTH, Critter.EAST, Critter.SOUTH, Critter.WEST };
      Random rng = new Random();
      return possibilities[rng.nextInt(possibilities.length - 1)];
    }

    public int turn() {
      // returns a direction based on which direction the Turtle moved in last
      // the Turtle moves clockwise
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
