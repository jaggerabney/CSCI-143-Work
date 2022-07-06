package com.jaggerabney.csci143.week8.projects;

import java.util.*;

public class Exercise21_01 {
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
    LinkedHashSet<String> workingSet1 = new LinkedHashSet<>(set1);
    LinkedHashSet<String> workingSet2 = new LinkedHashSet<>(set2);
    LinkedHashSet<String> elements = new LinkedHashSet<>();

    for (String element : workingSet1) {
      elements.add(element);
    }

    for (String element : workingSet2) {
      if (elements.contains(element)) {
        elements.remove(element);
      }
    }

    return elements;
  }

  public static LinkedHashSet<String> intersection(LinkedHashSet<String> set1, LinkedHashSet<String> set2) {
    LinkedHashSet<String> workingSet1 = new LinkedHashSet<>(set1);
    LinkedHashSet<String> workingSet2 = new LinkedHashSet<>(set2);
    LinkedHashSet<String> elements = new LinkedHashSet<>();

    for (String element : workingSet1) {
      if (workingSet2.contains(element)) {
        elements.add(element);
      }
    }

    return elements;
  }
}
