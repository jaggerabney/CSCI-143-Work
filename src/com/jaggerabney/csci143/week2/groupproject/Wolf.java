package com.jaggerabney.csci143.week2.groupproject;

import java.util.Random;

public class Wolf implements Critter {
  private boolean chasing;
  private char targetCritter;
  private int defaultChasingSteps, chasingSteps;
  public static final int[] cardinalDirections = new int[] { Critter.NORTH, Critter.EAST, Critter.SOUTH, Critter.WEST };

  public Wolf() {
    this.chasing = false;
    this.defaultChasingSteps = 8;
    this.chasingSteps = defaultChasingSteps;
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
        // find which direction will reduce the distance between this Wolf and its home
        // the most, and move there
        Random rng = new Random();
        return cardinalDirections[rng.nextInt(cardinalDirections.length)];
      } else {
        // if directionOfNearestCritter returned a direction, start moving in it
        // Wolves only chase critters for 8 steps before returning home, which
        // is why chasingSteps is subtracted from
        chasing = true;
        targetCritter = donc.getKey();
        chasingSteps = defaultChasingSteps;
        return donc.getValue();
      }
    } else {
      // when chasing an animal, scan surroundings to see where it went
      // Wolves will only chase the critter they are already chasing --
      // they won't be distacted by other critters unless they are not
      // actively chasing anything else
      donc = directionOfNearestCritter(info, targetCritter);

      // wolves can only see in the four cardinal directions around them, so if a
      // critter somehow moves to one of its diagonals, directionOfNearestCritter
      // will return 0 -- the Wolf will have "lost sight" of the animal
      // it stands in place for a step before moving back to its home.
      // alternatively, Wolves will stop chasing critters after 8 steps, which is
      // why it is in the condition here
      if (donc == null || chasingSteps == 0) {
        chasing = false;
        targetCritter = '.';
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
      if (viewedDirection != '.') {
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
}
