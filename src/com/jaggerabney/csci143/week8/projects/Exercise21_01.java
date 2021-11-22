package com.jaggerabney.csci143.week8.projects;

import java.util.*;

public class Exercise21_01 {
  public static void main(String[] args) {
    LinkedHashSet<String> lhs1 = new LinkedHashSet<>(
        Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
    LinkedHashSet<String> lhs2 = new LinkedHashSet<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));

    System.out.println("The union of the two sets is " + union(lhs1, lhs2));
    // System.out.println("The difference of the two sets is " + difference(lhs1,
    // lhs2));
    // System.out.println("The intersection of these two sets is " +
    // intersection(lhs1, lhs2));
  }

  public static LinkedHashSet<String> union(LinkedHashSet<String> set1, LinkedHashSet<String> set2) {
    LinkedHashSet<String> workingSet1 = new LinkedHashSet<>(set1);
    LinkedHashSet<String> workingSet2 = new LinkedHashSet<>(set2);
    LinkedHashSet<String> elements = new LinkedHashSet<>();

    for (String element : workingSet1) {
      elements.add(element);
    }

    for (String element : workingSet2) {
      if (!elements.contains(element)) {
        elements.add(element);
      }
    }

    return elements;
  }

  public static LinkedHashSet<String> difference(LinkedHashSet<String> set1, LinkedHashSet<String> set2) {
    return null;
  }

  public static LinkedHashSet<String> intersection(LinkedHashSet<String> set1, LinkedHashSet<String> set2) {
    return null;
  }
}
