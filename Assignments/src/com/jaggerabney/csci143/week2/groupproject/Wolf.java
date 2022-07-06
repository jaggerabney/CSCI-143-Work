package com.jaggerabney.csci143.week2.groupproject;

import java.util.Random;

public class Wolf implements Critter {
  private boolean chasing;
  private char targetCritter;
  private int defaultChasingSteps, chasingSteps, defaultStepsToMove, stepsToMove;
  public static final int[] cardinalDirections = new int[] { Critter.NORTH, Critter.EAST, Critter.SOUTH, Critter.WEST };

  public Wolf() {
    this.chasing = false;
    this.defaultChasingSteps = 20;
    this.defaultStepsToMove = 3;
    this.chasingSteps = defaultChasingSteps;
    this.stepsToMove = randomNumberInRange(1, 3);
  }

  @Override
  public char getChar() {
    // ! if the wolf is chasing a critter; W otherwise
    return (chasing) ? '!' : 'W';
  }

  @Override
  public int getMove(CritterInfo info) {
    Pair<Character, Integer> donc;

    if (!chasing) {
      // when not chasing an animal, scan surroundings to see if there are any animals
      // to chase
      donc = directionOfNearestCritter(info);

      // if not (i.e. if directionOfNearestCritter returns 0),
      // OR if the Wolf sees another Wolf, move in a random direction
      if (donc == null) {
        // when the Wolf is not chasing something, it will move in a random direction
        // every three steps; their starting steps before moving, however, is a
        // random number between one and three, so they don't all move in unison
        if (stepsToMove <= 0) {
          stepsToMove = defaultStepsToMove;
          return cardinalDirections[randomNumberInRange(0, 4)];
        } else {
          stepsToMove--;
          return Critter.CENTER;
        }
      } else {
        // if directionOfNearestCritter returned a direction, start moving in it
        // Wolves only chase critters for 20 steps
        chasing = true;
        targetCritter = donc.getKey();
        chasingSteps = defaultChasingSteps;
        stepsToMove = defaultStepsToMove;
        return donc.getValue();
      }
    } else {
      // when chasing an animal, scan surroundings to see where it went
      // Wolves will only chase the critter they are already chasing --
      // they won't be distacted by other critters unless they are not
      // actively chasing anything else

      // the exception to this is if another critter of the same type
      // moves next to the Wolf, in which case the first one to be
      // found (in clockwise order) will be the one chased
      donc = directionOfNearestCritter(info, targetCritter);

      // wolves can only see in the four cardinal directions around them, so if a
      // critter somehow moves to one of its diagonals, directionOfNearestCritter
      // will return 0 -- the Wolf will have "lost sight" of the animal
      // it stands in place for a step before returning to its random movement
      // alternatively, Wolves will stop chasing critters after 20 steps, which is
      // why it is in the condition here
      if (donc == null || chasingSteps == 0) {
        chasing = false;
        targetCritter = '.';
        stepsToMove = defaultStepsToMove;
        return Critter.CENTER;
      } else {
        // if the Wolf sees the animal, it chases it
        chasingSteps--;
        return donc.getValue();
      }
    }
  }

  private Pair<Character, Integer> directionOfNearestCritter(CritterInfo info) {
    // finds if there is a critter above, to the left of, below, or to the right of
    // the Wolf, ignoring any periods (which represent blank spaces) and w's (which
    // represent other Wolves -- after all, they're pack animals)
    char viewedDirection;

    for (int i = 0; i < cardinalDirections.length; i++) {
      viewedDirection = info.getNeighbor(cardinalDirections[i]);
      if (viewedDirection != '.' && viewedDirection != 'W' && viewedDirection != '!') {
        return new Pair<Character, Integer>(viewedDirection, cardinalDirections[i]);
      }
    }

    return null;
  }

  private Pair<Character, Integer> directionOfNearestCritter(CritterInfo info, char critter) {
    // same function as above, but with an extra character parameter
    // different critters are represented by different characters, so for the
    // Wolf to give chase to them, it has to make sure it's chasing the correct
    // critter (by checking it's character)
    char viewedDirection;
    for (int i = 0; i < cardinalDirections.length; i++) {
      viewedDirection = info.getNeighbor(cardinalDirections[i]);
      if (viewedDirection == critter) {
        return new Pair<Character, Integer>(viewedDirection, cardinalDirections[i]);
      }
    }

    return null;
  }

  // helper function that produces a random number in a specified range
  private static int randomNumberInRange(int lowerBound, int upperBound) {
    Random random = new Random();
    return random.nextInt(upperBound - lowerBound) + lowerBound;
  }
}

// helper class used by a Wolf when chasing a critter
// stores a basic key-value pair -- in the case of the Wolf, the key
// is the critter's character and the value is what direction it is
// relative to the Wolf
class Pair<T1, T2> {
  private T1 key;
  private T2 value;

  public Pair(T1 key, T2 value) {
    this.key = key;
    this.value = value;
  }

  public void setKey(T1 key) {
    this.key = key;
  }

  public T1 getKey() {
    return key;
  }

  public void setValue(T2 value) {
    this.value = value;
  }

  public T2 getValue() {
    return value;
  }
}
