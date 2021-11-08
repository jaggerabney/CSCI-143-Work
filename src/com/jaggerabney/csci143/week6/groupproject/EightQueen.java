package com.jaggerabney.csci143.week6.groupproject;

public class EightQueen {
  // chessboard is represented by a 2D boolean array.
  // if a value is true, then there is a queen there;
  // if a value is false, then there is nothing there
  private boolean[][] chessboard;
  private static final int NUM_QUEENS = 8;

  // constructor and getter for chessboard
  public EightQueen() {
    chessboard = new boolean[NUM_QUEENS][NUM_QUEENS];
  }

  public boolean[][] getChessboard() {
    return chessboard;
  }

  // this is where the recursive method is started.
  // since the recursion relies on columns and their indices,
  // the helper function has a col parameter
  public void placeQueens() {
    placeQueens(0);
  }

  // helper function that does the work of placing the queens
  private boolean placeQueens(int col) {
    // current is used to store the current space
    Space current = null;

    // base case: col equals (or is greater than)
    // the total amount of columns on the board.
    // when this happens, it means that all placements
    // of the queens are valid, and so the method returns
    // true (which ceases its recursion)
    if (col >= NUM_QUEENS) {
      return true;
    } else {
      // otherwise, the method loops through the given column,
      // testing if the space (i, col) works or not using
      // recursive backtracking
      for (int i = 0; i < NUM_QUEENS; i++) {
        current = new Space(i, col);

        // if the queen is not vulnerable at this position
        // (i.e. if it can't be attacked by other queens),
        // then it is placed here and the method recurses
        // in the if condition
        if (!isVulnerable(new Space(i, col), 0)) {
          placeQueenAt(current);

          // if the next column's queen placement is valid,
          // then return true.
          // due to the recursive nature of this method,
          // this if condition will only evaluate true if
          // ALL columns are valid
          if (placeQueens(col + 1)) {
            return true;
          }

          // if the subsequent column has no valid queen
          // placements, then that means that the placement
          // of this column's queen is invalid; in that case,
          // remove it and try moving it down one
          removeQueenFrom(current);
        }
      }
    }

    // only reached after the for loop completes - in other words,
    // when there are no valid queen placements for the given col
    return false;
  }

  // method used to determine if a given space can hold a queen
  // takes two parameters: a Space (which is the space on the
  // chessboard being tested), and an int (which represents the
  // index of the given direction being tested - see below)
  private boolean isVulnerable(Space space, int directionIndex) {
    // starts by getting all eight values of the Direction enum:
    // N, NE, E, SE, S, SW, W, and NW.
    // these represent the eight directions in which a queen can move.
    Direction[] directions = Direction.values();

    // directionIndex is used not only to access directions, but
    // also to test the base case: when all directions have been
    // tested and are clear.
    if (directionIndex >= directions.length) {
      return false;
      // this if block uses the recursive method noQueenInDirection
      // to test if there are any queens in a given direction, specified
      // by a Direction enum.
      // it returns true if and only if there are no queens in any of
      // the eight directions that the given queen can move to
    } else if (noQueenInDirection(space, directions[directionIndex])) {
      return isVulnerable(space, directionIndex + 1);
    } else {
      // if directionIndex is still within the bounds of the
      // directions array AND noQueenInDirection returns false,
      // then that means that this space is not a valid position
      // for a queen; as such, it returns false
      return true;
    }
  }

  // this method uses recursion to test if a queen is located in
  // a specified direction
  private boolean noQueenInDirection(Space space, Direction direction) {
    // each call of the method begins by incrementing/decrementing
    // the row and col as specified by the Direction enum.
    // each of the eight Directions contains two ints that represent
    // what you'd need to add to a space to move in that direction.
    // e.g., SOUTHWEST contains 1 & -1, since you'd need to add to
    // the row to move south and subtract from the col to move west
    Space newSpace = new Space(space.row + direction.rowChange(), space.col + direction.colChange());

    // spaceIsBeyondBoundsOfBoard is just a helper function that
    // returns true is a given space is not on the board.
    // for example, passing the Space (9, 9) would cause this
    // method to return true, as it's outside of the board
    // (which has indices from 0 to 7).

    // if this function is true, then it means that the given
    // direction has been fully tested, and as such, there is no
    // queen in this direction
    if (spaceIsBeyondBoundsOfBoard(newSpace)) {
      return true;
      // if there is no queen at the new space, then recurse
      // until either there is or until the edge of the board is hit
    } else if (noQueenAt(newSpace)) {
      return noQueenInDirection(newSpace, direction);
    } else {
      return false;
    }
  }

  // helper function that returns true if a space is not on the chessboard
  private boolean spaceIsBeyondBoundsOfBoard(Space space) {
    return (space.row > NUM_QUEENS - 1 || space.col > NUM_QUEENS - 1 || space.row < 0 || space.col < 0);
  }

  // helper function that "places" a queen on the specified Space by setting
  // the corresponding element in the chessboard 2D array to true.
  // this function really only exists to more clearly demonstrate what is going on
  private void placeQueenAt(Space space) {
    chessboard[space.row][space.col] = true;
  }

  // same as above, but it removes the queen instead of placing it
  private void removeQueenFrom(Space space) {
    chessboard[space.row][space.col] = false;
  }

  // boolean function that returns true if there is no queen at the
  // specified Space - that is, if the corresponding element in the
  // chessboard 2D array is false
  private boolean noQueenAt(Space space) {
    return !chessboard[space.row][space.col];
  }

  // toString override for debugging
  @Override
  public String toString() {
    String result = "";
    boolean followedByComma;

    for (int i = 0; i < chessboard.length; i++) {
      result += "[";
      for (int j = 0; j < chessboard[i].length; j++) {
        followedByComma = j != chessboard[i].length - 1;
        result += chessboard[i][j] ? "1" : "0";
        result += (followedByComma) ? ", " : "";
      }
      result += "]\n";
    }

    return result;
  }
}
