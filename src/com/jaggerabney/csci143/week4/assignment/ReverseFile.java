/**
 * Filename: ReverseFile.java
 * Author: Jagger Abney
 * Purpose: to reverse the contents of a file 
 */

package com.jaggerabney.csci143.week4.assignment;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class ReverseFile {
  public static final String FILE_NAME = "mobydick.txt";

  public static ArrayList<String> readFile(String filename) throws Exception {
    // creates an InputStream, InputStreamReader, and BufferedReader (the former
    // two are used to create the last, which is what is used to read the file)
    InputStream is = ReverseFile.class.getResourceAsStream(filename);
    InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
    BufferedReader br = new BufferedReader(isr);
    // lines from the file are added to fileContents, and stored temporarily
    // in line
    ArrayList<String> fileContents = new ArrayList<String>();
    String line;

    // stores lines of the file into fileContents so long as there are lines
    // to store
    while ((line = br.readLine()) != null) {
      fileContents.add(line);
    }

    // returns the result
    return fileContents;
  }

  public static ArrayList<String> reverse(ArrayList<String> list) {
    ArrayList<String> reversedList = new ArrayList<String>();

    // iterates through the passed list in reverse order, reversing the current line
    // and adding it to the reversedList ArrayList
    for (int i = list.size() - 1; i >= 0; i--) {
      reversedList.add(reverse(list.get(i)));
    }

    return reversedList;
  }

  public static String reverse(String string) {
    ArrayList<Character> reversedString = new ArrayList<>();

    // iterates through the characters of the array and adds them to reversedString
    for (int i = string.length() - 1; i >= 0; i--) {
      reversedString.add(string.charAt(i));
    }

    // converts the reversedString ArrayList to a string using a lambda & returns it
    return reversedString.stream().map(e -> e.toString()).collect(Collectors.joining());
  }

  public static void writeToFile(ArrayList<String> contents) throws Exception {
    // creates a FileWriter for use in writing to the file
    FileWriter fw = new FileWriter(FILE_NAME);

    // writes each line of the contents ArrayList to the file, inserting line breaks
    // between elements to preserve the formatting of the file
    for (String line : contents) {
      fw.write(line + "\n");
    }

    // closes the FileWriter
    fw.close();
  }
}
