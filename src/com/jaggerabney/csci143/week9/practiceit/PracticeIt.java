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

  public boolean isFull() {
    return (overallRoot != null) ? isFull(overallRoot) : true;
  }

  private boolean isFull(IntTreeNode root) {
    if (root != null && hasTwoChildren(root)) {
      return isFull(root.left) && isFull(root.right);
    } else if (isLeaf(root)) {
      return true;
    } else {
      return false;
    }
  }

  private boolean hasTwoChildren(IntTreeNode node) {
    return (node.left != null && node.right != null);
  }

  public String toString2() {
    return toString2(overallRoot);
  }

  private String toString2(IntTreeNode root) {
    if (root != null && hasChildren(root)) {
      return "(" + root.data + ", " + toString2(root.left) + ", " + toString2(root.right) + ")";
    } else if (root != null && hasNoChildren(root)) {
      return String.valueOf(root.data);
    } else {
      return "empty";
    }
  }

  public boolean hasChildren(IntTreeNode node) {
    return node.left != null || node.right != null;
  }

  public boolean hasNoChildren(IntTreeNode node) {
    return node.left == null && node.right == null;
  }

  public boolean equals2(IntTree other) {
    return equals2(overallRoot, other.overallRoot);
  }

  private boolean equals2(IntTreeNode root1, IntTreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    } else if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
      return false;
    } else {
      return (root1.data == root2.data) && equals2(root1.left, root2.left) && equals2(root1.right, root2.right);
    }
  }

  public void doublePositives() {
    doublePositives(overallRoot);
  }

  private void doublePositives(IntTreeNode root) {
    if (root == null) {
      return;
    } else {
      if (root.data > 0) {
        root.data *= 2;
      }

      doublePositives(root.left);
      doublePositives(root.right);
    }
  }

  public void numberNodes() {
    numberNodes(overallRoot, 1);
  }

  private int numberNodes(IntTreeNode root, int index) {
    if (root != null) {
      root.data = index;
      int temp = numberNodes(root.left, index + 1);
      return 1 + temp + numberNodes(root.right, index + temp + 1);
    } else {
      return 0;
    }
  }

  public void removeLeaves() {
    if (overallRoot == null) {
      return;
    } else if (isLeaf(overallRoot)) {
      overallRoot = null;
    } else {
      removeLeaves(overallRoot);
    }
  }

  private void removeLeaves(IntTreeNode root) {
    if (root != null) {
      if (root.left != null && isLeaf(root.left)) {
        root.left = null;
      }

      if (root.right != null && isLeaf(root.right)) {
        root.right = null;
      }

      removeLeaves(root.left);
      removeLeaves(root.right);
    }
  }

  public void completeToLevel(int level) {
    if (level < 1) {
      throw new IllegalArgumentException("level must be greater than one");
    } else if (overallRoot == null) {
      overallRoot = new IntTreeNode(-1);
      completeToLevel(overallRoot, level, 1);
    } else {
      completeToLevel(overallRoot, level, 1);
    }
  }

  private void completeToLevel(IntTreeNode root, int targetLevel, int currentLevel) {
    if (currentLevel < targetLevel) {
      if (root.left == null) {
        root.left = new IntTreeNode(-1);
      }
      if (root.right == null) {
        root.right = new IntTreeNode(-1);
      }

      completeToLevel(root.left, targetLevel, currentLevel + 1);
      completeToLevel(root.right, targetLevel, currentLevel + 1);
    }
  }

  public void trim(int min, int max) {
    overallRoot = trim(overallRoot, min, max);
  }

  private IntTreeNode trim(IntTreeNode root, int min, int max) {
    if (root != null) {
      if (root.data < min) {
        return trim(root.right, min, max);
      } else if (root.data > max) {
        return trim(root.left, min, max);
      } else {
        root.left = trim(root.left, min, max);
        root.right = trim(root.right, min, max);
        return root;
      }
    } else {
      return null;
    }
  }

  public void tighten() {
    overallRoot = tighten(overallRoot);
  }

  private IntTreeNode tighten(IntTreeNode root) {
    if (root != null && hasOneChild(root)) {
      IntTreeNode child = (root.right == null) ? root.left : root.right;
      return tighten(child);
    } else if (root != null && hasTwoChildren(root)) {
      root.left = tighten(root.left);
      root.right = tighten(root.right);
      return root;
    } else if (root != null && hasNoChildren(root)) {
      return root;
    } else {
      return null;
    }
  }

  private boolean hasOneChild(IntTreeNode node) {
    return (node.left == null) != (node.right == null);
  }

  public IntTree combineWith(IntTree other) {
    return new IntTree(combineWith(overallRoot, other.overallRoot));
  }

  private IntTreeNode combineWith(IntTreeNode tree1, IntTreeNode tree2) {
    IntTreeNode node = new IntTreeNode(0);

    if (tree1 != null && tree2 != null) {
      node.data = 3;
      node.left = combineWith(tree1.left, tree2.left);
      node.right = combineWith(tree1.right, tree2.right);
      return node;
    } else if (tree1 != null && tree2 == null) {
      node.data = 1;
      node.left = combineWith(tree1.left, null);
      node.right = combineWith(tree1.right, null);
      return node;
    } else if (tree1 == null && tree2 != null) {
      node.data = 2;
      node.left = combineWith(null, tree2.left);
      node.right = combineWith(null, tree2.right);
      return node;
    } else {
      return null;
    }
  }
}
