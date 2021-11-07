package com.jaggerabney.csci143.week6.groupproject;

public class EightQueen {
  private boolean[][] chessboard;
  private static final int NUM_QUEENS = 8;

  public EightQueen() {
    chessboard = new boolean[8][8];
  }

  public boolean[][] getChessboard() {
    return chessboard;
  }

  public void placeQueens() {
    placeQueens(0, 0, NUM_QUEENS);
  }

  private void placeQueens(int row, int col, int numQueens) {
    if (numQueens > 0) {
      placeQueenAt(row, col);

      if (isVulnerable(row, col, 0)) {
        removeQueenFrom(row, col);

        if (spaceIsBeyondBoundsOfBoard(row + 1, col)) {
          placeQueens(0, col + 1, numQueens);
        } else {
          placeQueens(row + 1, col, numQueens);
        }
      } else {
        numQueens--;
        System.out.println("Placed queen at (" + row + ", " + col + ")");

        if (spaceIsBeyondBoundsOfBoard(row + 1, col)) {
          placeQueens(0, col + 1, numQueens);
        } else {
          placeQueens(row + 1, col, numQueens);
        }
      }
    }
  }

  private boolean isVulnerable(int row, int col, int directionIndex) {
    Direction[] directions = Direction.values();

    if (directionIndex >= directions.length) {
      return false;
    } else if (noQueenInDirection(row, col, directions[directionIndex])) {
      return isVulnerable(row, col, directionIndex + 1);
    } else {
      return true;
    }
  }

  private boolean noQueenInDirection(int row, int col, Direction direction) {
    if (spaceIsBeyondBoundsOfBoard(row, col)) {
      return true;
    } else if (noQueenAt(row, col)) {
      return noQueenInDirection(row + direction.rowChange(), col + direction.colChange(), direction);
    } else {
      return false;
    }
  }

  private boolean spaceIsBeyondBoundsOfBoard(int row, int col) {
    return (row > 7 || col > 7 || row < 0 || col < 0);
  }

  private void placeQueenAt(int row, int col) {
    System.out.println("(" + row + ", " + col + ")");
    chessboard[row][col] = true;
  }

  private void removeQueenFrom(int row, int col) {
    chessboard[row][col] = false;
  }

  // private boolean queenAt(int row, int col) {
  // return chessboard[row][col];
  // }

  private boolean noQueenAt(int row, int col) {
    return !chessboard[row][col];
  }

  @Override
  public String toString() {
    String result = "";
    boolean followedByComma;

    for (int i = 0; i < chessboard.length; i++) {
      result += "[";
      for (int j = 0; j < chessboard[i].length; j++) {
        followedByComma = j != chessboard[i].length - 1;
        result += chessboard[i][j];
        result += (followedByComma) ? ", " : "";
      }
      result += "]\n";
    }

    return result;
  }
}
