package com.jaggerabney.csci143.week5.practiceit;

import java.util.*;

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

  public static String vowelsToEnd(String string) {
    return vowelsToEnd(string, "", 0);
  }

  private static String vowelsToEnd(String string, String vowels, int index) {
    if (index >= string.length()) {
      return string + vowels;
    } else if (isVowel(string.charAt(index))) {
      char vowel = string.charAt(index);
      String result = string.substring(0, index) + string.substring(index + 1);
      String newVowels = vowel + vowels;
      return vowelsToEnd(result, newVowels, index);
    } else {
      return vowelsToEnd(string, vowels, index + 1);
    }
  }

  private static boolean isVowel(char character) {
    ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    return vowels.contains(character);
  }

  public static int evenDigits(int n) {
    return evenDigits(n, 0) * ((n < 0) ? -1 : 1);
  }

  private static int evenDigits(int n, int index) {
    String numberAsString = String.valueOf(n);
    System.out.println(numberAsString);

    if (index >= numberAsString.length()) {
      return n;
    } else if (Character.getNumericValue(numberAsString.charAt(index)) % 2 == 0) {
      return evenDigits(n, index + 1);
    } else {
      String result = numberAsString.substring(0, index) + numberAsString.substring(index + 1);

      if (result.length() >= 1) {
        return evenDigits(Integer.parseInt(result), index);
      } else {
        return 0;
      }
    }
  }

  public static void waysToClimb(int n) {
    if (n > 0) {
      waysToClimb(n, 0, "[");
    }
  }

  private static void waysToClimb(int n, int index, String result) {
    if (n == index) {
      result += "]";
      System.out.println(result);
      return;
    } else if (index < n) {
      waysToClimb(n, index + 1, result + ((index + 1 == n) ? "1" : "1, "));
      waysToClimb(n, index + 2, result + ((index + 2 == n) ? "2" : "2, "));
    }
  }

  public static void countBinary(int n) {
    countBinary(n, "");
  }

  private static void countBinary(int n, String result) {
    if (n > 0) {
      countBinary(n - 1, result + "0");
      countBinary(n - 1, result + "1");
    } else {
      System.out.println(result);
      return;
    }
  }

  public static void subsets(List<String> list) {
    subsets(list, 0);
  }

  private static void subsets(List<String> list, int index) {
    if (index < list.size()) {
      subsets(list, index + 1);
      String temp = list.remove(index);
      subsets(list, index);
      list.add(index, temp);
    } else {
      System.out.println(list);
    }
  }

  public static int maxSum(List<Integer> list, int limit) {
    ArrayList<String> permutations = new ArrayList<>();
    allBinaryPermutations(list.size(), "", permutations);
    int sum = sumListAccordingToPermutation(list, permutations.get(0), 0); // first sum
    return maxSum(list, limit, permutations, sum, 0);
  }

  private static int maxSum(List<Integer> list, int limit, List<String> permutations, int sum, int permutationsIndex) {
    if (permutationsIndex < permutations.size()) {
      int permutationSum = sumListAccordingToPermutation(list, permutations.get(permutationsIndex), 0);
      if (permutationSum > sum && permutationSum <= limit) {
        sum = permutationSum;
      }
      return maxSum(list, limit, permutations, sum, permutationsIndex + 1);
    } else {
      return sum;
    }
  }

  public static void allBinaryPermutations(int digits, String result, List<String> list) {
    if (digits > 0) {
      allBinaryPermutations(digits - 1, result + "0", list);
      allBinaryPermutations(digits - 1, result + "1", list);
    } else {
      list.add(result);
      return;
    }
  }

  private static int sumListAccordingToPermutation(List<Integer> list, String permutation, int index) {
    if (index < list.size()) {
      int bit = Character.getNumericValue(permutation.charAt(index));
      int result = (bit == 1) ? list.get(index) : 0;
      return result + sumListAccordingToPermutation(list, permutation, index + 1);
    } else {
      return 0;
    }
  }

  public static void printSquares(int n) {
    ArrayList<String> permutations = new ArrayList<>();
    int sqrtN = (int) Math.sqrt(n);
    allBinaryPermutations(sqrtN, "", permutations);
    Collections.reverse(permutations);
    ArrayList<String> sums = new ArrayList<>();
    for (String permutation : permutations) {
      int sum = 0;
      String result = "";

      for (int i = 0; i < permutation.toCharArray().length; i++) {
        int bit = Character.getNumericValue(permutation.charAt(i));
        if (bit == 1) {
          sum += Math.pow(i + 1, 2);
          result += (sum == n) ? (i + 1 + "^2") : (i + 1 + "^2 + ");
        }
      }

      if (sum == n && !sums.contains(result)) {
        sums.add(result);
        System.out.println(result);
      }
    }
    return;
  }
}