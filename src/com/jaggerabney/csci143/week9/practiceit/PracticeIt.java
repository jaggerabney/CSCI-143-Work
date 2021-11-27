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

  public int countEvenBranches() {
    return countEvenBranches(overallRoot);
  }

  private int countEvenBranches(IntTreeNode root) {
    if (root != null && !isLeaf(root)) {
      return (isEven(root.data) ? 1 : 0) + countEvenBranches(root.left) + countEvenBranches(root.right);
    } else {
      return 0;
    }
  }

  private boolean isLeaf(IntTreeNode node) {
    return node.left == null && node.right == null;
  }

  private boolean isEven(int value) {
    return value % 2 == 0;
  }

  public void printLevel(int level) {
    if (level >= 1) {
      printLevel(overallRoot, level, 1);
    } else {
      throw new IllegalArgumentException("level cannot be less than one");
    }
  }

  private void printLevel(IntTreeNode root, int targetLevel, int currentLevel) {
    if (currentLevel == targetLevel && root != null) {
      System.out.println(root.data);
    } else if (root != null) {
      printLevel(root.left, targetLevel, currentLevel + 1);
      printLevel(root.right, targetLevel, currentLevel + 1);
    }
  }

  public void printLeaves() {
    String result = printLeaves(overallRoot);
    if (!result.isEmpty()) {
      System.out.println("leaves: " + result);
    } else {
      System.out.println("no leaves");
    }
  }

  private String printLeaves(IntTreeNode root) {
    if (root != null && isLeaf(root)) {
      return root.data + " ";
    } else if (root != null) {
      return printLeaves(root.right) + printLeaves(root.left);
    } else {
      return "";
    }
  }
}
