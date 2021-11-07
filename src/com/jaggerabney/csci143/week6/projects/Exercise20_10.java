package com.jaggerabney.csci143.week6.projects;

import java.util.*;

public class Exercise20_10 {
  public static void main(String[] args) {
    PriorityQueue<String> pq1 = new PriorityQueue<>(
        Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
    PriorityQueue<String> pq2 = new PriorityQueue<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));

    System.out.println("The union of the two priority queues is " + union(pq1, pq2));
    System.out.println("The difference of the two priority queues is " + difference(pq1, pq2));
  }

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
}
