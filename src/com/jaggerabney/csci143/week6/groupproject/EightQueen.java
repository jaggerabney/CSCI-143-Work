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
    placeQueenAt(row, col);
  }

  private void placeQueenAt(int row, int col) {
    chessboard[row][col] = true;
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
