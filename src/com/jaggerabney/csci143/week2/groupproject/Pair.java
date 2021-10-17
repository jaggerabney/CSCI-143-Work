package com.jaggerabney.csci143.week2.groupproject;

// basic utility class that stores a key-value pair
// used in the Wolf class, to store the char representation of a 
// critter, and where it is relative to the Wolf
public class Pair<T1, T2> {
  private T1 key;
  private T2 value;

  public Pair(T1 key, T2 value) {
    this.key = key;
    this.value = value;
  }

  public void setKey(T1 key) {
    this.key = key;
  }

  public T1 getKey() {
    return key;
  }

  public void setValue(T2 value) {
    this.value = value;
  }

  public T2 getValue() {
    return value;
  }
}
