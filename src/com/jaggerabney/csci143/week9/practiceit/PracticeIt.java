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

  public int countEmpty() {
    return (overallRoot != null) ? countEmpty(overallRoot) : 1;
  }

  private int countEmpty(IntTreeNode root) {
    if (root != null) {
      int leftChildEmpty = (root.left == null) ? 1 : 0;
      int rightChildEmpty = (root.right == null) ? 1 : 0;
      return leftChildEmpty + rightChildEmpty + countEmpty(root.left) + countEmpty(root.right);
    } else {
      return 0;
    }
  }

  public int depthSum() {
    return depthSum(overallRoot, 1);
  }

  private int depthSum(IntTreeNode root, int level) {
    if (root != null) {
      return (root.data * level) + depthSum(root.left, level + 1) + depthSum(root.right, level + 1);
    } else {
      return 0;
    }
  }
}
