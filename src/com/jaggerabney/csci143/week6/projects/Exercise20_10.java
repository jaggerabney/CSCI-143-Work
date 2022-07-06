package com.jaggerabney.csci143.week6.projects;

import java.util.*;

public class Exercise20_10 {
  public static PriorityQueue<String> union(PriorityQueue<String> pq1, PriorityQueue<String> pq2) {
    PriorityQueue<String> result = new PriorityQueue<>();
    result.addAll(pq1);
    result.addAll(pq2);
    return result;
  }

  public static PriorityQueue<String> difference(PriorityQueue<String> pq1, PriorityQueue<String> pq2) {
    PriorityQueue<String> result = new PriorityQueue<>();

    result.addAll(pq1);
    result.addAll(pq2);
    result.removeAll(pq2);

    return result;
  }

  public static PriorityQueue<String> intersection(PriorityQueue<String> pq1, PriorityQueue<String> pq2) {
    PriorityQueue<String> temp = new PriorityQueue<>();

    temp.addAll(pq1);
    temp.addAll(pq2);
    temp.retainAll(pq1);
    temp.retainAll(pq2);

    return new PriorityQueue<String>(new ArrayList<String>(new HashSet<>(temp)));
  }
}
