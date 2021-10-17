package com.jaggerabney.csci143.week2.groupproject;

import java.util.*;

import java.awt.Point;

public class Wolf implements Critter {
  private boolean chasing;
  private char targetCritter;
  private Point home;
  private int defaultChasingSteps, chasingSteps;
  public static final int[] cardinalDirections = new int[] { Critter.NORTH, Critter.EAST, Critter.SOUTH, Critter.WEST };

  public Wolf() {
    this.chasing = false;
    this.defaultChasingSteps = 8;
    this.chasingSteps = defaultChasingSteps;
  }

  @Override
  public char getChar() {
    return (chasing) ? '!' : 'W';
  }

  @Override
  public int getMove(CritterInfo info) {
    // set "home" (only runs on init)
    if (home == null) {
      home = new Point(info.getX(), info.getY());
    }

    Pair<Character, Integer> donc;

    if (!chasing) {
      // when not chasing an animal, scan surroundings to see if there are any animals
      // to chase
      donc = directionOfNearestCritter(info);

      // if not (i.e. if directionOfNearestCritter returns 0)
      if (donc == null) {
        // find which direction will reduce the distance between this Wolf and its home
        // the most, and move there
        int directionToMove = findBestDirectionToMove(home, new Point(info.getX(), info.getY()));
        return directionToMove;
      } else {
        // if directionOfNearestCritter returned a direction, start moving in it
        // Wolves only chase critters for 8 steps before returning home, which
        // is why chasingSteps is subtracted from
        chasing = true;
        targetCritter = donc.getKey();
        chasingSteps = defaultChasingSteps;
        chasingSteps--;
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
    char viewedDirection;
    System.out.println(critter);
    for (int i = 0; i < cardinalDirections.length; i++) {
      viewedDirection = info.getNeighbor(cardinalDirections[i]);
      System.out.println(viewedDirection);
      if (viewedDirection == critter) {
        System.out.println(cardinalDirections[i]);
        return new Pair<Character, Integer>(viewedDirection, cardinalDirections[i]);
      }
    }

    return null;
  }

  private double distance(Point point1, Point point2) {
    return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));
  }

  private int findBestDirectionToMove(Point home, Point critterInfo) {
    double[] distances = new double[4];
    double lowestDistance = distance(home, critterInfo);
    int indexOfLowestDistance = 0;

    for (int i = 0; i < distances.length; i++) {
      distances[i] = distance(home, critterInfo);

      if (distances[i] < lowestDistance) {
        lowestDistance = distances[i];
        indexOfLowestDistance = i;
      }
    }

    return cardinalDirections[indexOfLowestDistance];
  }
}
