package com.jaggerabney.csci143.week5.practiceit;

public class PracticeIt {
  public static String starString(int times) {
    if (times == 0) {
      return "*";
    } else if (times > 0) {
      return starString(times - 1) + starString(times - 1);
    } else {
      throw new IllegalArgumentException("times must be less than zero.");
    }
  }

  public static void writeNums(int times) {
    if (times == 1) {
      System.out.print("1");
    } else if (times > 1) {
      writeNums(times - 1);
      System.out.print(", " + times);
    } else {
      throw new IllegalArgumentException("times must be greater than one.");
    }
  }

  public static void writeSequence(int times) {
    if (times == 1) {
      System.out.print("1 ");
    } else if (times > 1) {
      System.out.print(((times + 1) / 2) + " ");
      if (times > 2) {
        writeSequence(times - 2);
      }
      System.out.print(((times + 1) / 2) + " ");
    } else {
      throw new IllegalArgumentException("times must be greater than one.");
    }
  }

  public static void writeSquares(int n) {
    if (n == 1) {
      System.out.print("1");
    } else if (n > 1) {
      if (n % 2 == 0) { // n is even
        System.out.print(((n - 1) * (n - 1)));
        if (n != 2) {
          System.out.print(", ");
          writeSquares(n - 2);
        }
        System.out.print(", " + (n * n));
      } else { // n is odd
        System.out.print((n * n) + ", ");
        if (n != 2)
          writeSquares(n - 2);
        System.out.print(", " + ((n - 1) * (n - 1)));
      }
    } else {
      throw new IllegalArgumentException("n must be greater than one.");
    }
  }

  public static void writeChars(int n) {
    if (n < 1) {
      throw new IllegalArgumentException("n must be greater than one");
    } else if (n == 1) {
      System.out.print("*");
    } else if (n == 2) {
      System.out.print("**");
    } else {
      System.out.print("<");
      writeChars(n - 2);
      System.out.print(">");
    }
  }

  public static int multiplyEvens(int n) {
    if (n < 1) {
      throw new IllegalArgumentException("n must be greater than one");
    } else if (n == 1) {
      return 2;
    } else {
      return (2 * n) * multiplyEvens(n - 1);
    }
  }

  public static double sumTo(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n must be greater than zero");
    } else if (n == 0) {
      return 0.0;
    } else if (n == 1) {
      return 1.0;
    } else {
      return (1.0 / n) + sumTo(n - 1);
    }
  }

  public static int digitMatch(int n1, int n2) {
    String first = String.valueOf(n1), second = String.valueOf(n2);
    int firstEnd = first.length() - 1, secondEnd = second.length() - 1;
    int lastDigitsMatch = (first.charAt(firstEnd) == second.charAt(secondEnd)) ? 1 : 0;

    if (n1 < 0 || n2 < 0) {
      throw new IllegalArgumentException("arguments must be positive");
    } else if (first.length() == 1 || second.length() == 1) {
      return lastDigitsMatch;
    } else {
      return lastDigitsMatch + digitMatch(n1 / 10, n2 / 10);
    }
  }

  public static String repeat(String s, int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n must be greater than zero");
    } else if (n == 0) {
      return "";
    } else {
      return s + repeat(s, n - 1);
    }
  }

  public static boolean isReverse(String string1, String string2) {
    if (string1.isEmpty() && string2.isEmpty()) {
      return true;
    } else if (string1.length() != string2.length()) {
      return false;
    } else {
      char c1 = Character.toLowerCase(string1.charAt(0));
      char c2 = Character.toLowerCase(string2.charAt(string2.length() - 1));
      boolean result = c1 == c2;
      return result && isReverse(string1.substring(1), string2.substring(0, string2.length() - 1));
    }
  }

  public static int indexOf(String stringToSearch, String stringToFind) {
    return indexOf(stringToSearch, stringToFind, 0);
  }

  private static int indexOf(String stringToSearch, String stringToFind, int index) {
    if (stringToSearch.length() < stringToFind.length()) {
      return -1;
    } else if (stringToSearch.substring(0, stringToFind.length()).equals(stringToFind)) {
      return index;
    } else {
      index++;
      return indexOf(stringToSearch.substring(1), stringToFind, index);
    }
  }

  public static String dedup(String string) {
    return dedup(string, 0);
  }

  private static String dedup(String string, int index) {
    if (string.length() <= 1 || index >= string.length() - 2) {
      return string;
    } else if (string.charAt(index) != string.charAt(index + 1)) {
      return dedup(string, index + 1);
    } else {
      String result = string.substring(0, index) + string.substring(index + 1);
      return dedup(result, index);
    }
  }
}
