package com.jaggerabney.csci143.week4.assignment;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class ReverseFile {
  public static ArrayList<String> readFile(String filename) throws Exception {
    InputStream is = ReverseFile.class.getResourceAsStream(filename);
    InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
    BufferedReader br = new BufferedReader(isr);
    ArrayList<String> fileContents = new ArrayList<String>();
    String line;

    while ((line = br.readLine()) != null) {
      fileContents.add(line);
    }

    return fileContents;
  }

  public static ArrayList<String> reverse(ArrayList<String> list) {
    ArrayList<String> reversedList = new ArrayList<String>();

    for (int i = list.size() - 1; i >= 0; i--) {
      reversedList.add(reverse(list.get(i)));
    }

    return reversedList;
  }

  public static String reverse(String string) {
    ArrayList<Character> reversedString = new ArrayList<>();

    for (int i = string.length() - 1; i >= 0; i--) {
      reversedString.add(string.charAt(i));
    }

    return reversedString.stream().map(e -> e.toString()).collect(Collectors.joining());
  }
}
