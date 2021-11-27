package com.jaggerabney.csci143.week9.practiceit;

public class PracticeIt extends IntTree {
  public PracticeIt(String s) {
    super(s);
  }

  public int countLeftNodes() {
    return countLeftNodes(overallRoot);
  }

  private int countLeftNodes(IntTreeNode root) {
    if (root != null) {
      int hasLeftNode = (root.left != null) ? 1 : 0;
      return hasLeftNode + countLeftNodes(root.left) + countLeftNodes(root.right);
    } else {
      return 0;
    }
  }
}
