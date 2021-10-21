package com.jaggerabney.csci143.week4.assignment;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

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
}
