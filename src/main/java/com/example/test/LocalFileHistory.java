package com.example.test;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalFileHistory {

    public static File history=new File("history.txt");


    public LocalFileHistory() throws IOException {
        ///This is the history of main application
        FileWriter fileWriter = new FileWriter(history, true);
        LocalDateTime openTime = LocalDateTime.now();
        DateTimeFormatter openTimeReadable = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = openTime.format(openTimeReadable);
        System.out.println("Application has been opened on "+ formattedDate+"\n");
        fileWriter.write("Application has been opened on " + formattedDate+"\n");
        fileWriter.close();
    }

 public static LocalFileHistory watermarkAdded(String fileName) throws IOException
 {

     FileWriter fileWriter = new FileWriter(history, true);
     LocalDateTime openTime = LocalDateTime.now();
     DateTimeFormatter openTimeReadable = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
     String formattedDate = openTime.format(openTimeReadable);
     System.out.println(Main.filenameInputtedByUser());
     fileWriter.write("Watermark has been added to "+ Main.filenameInputtedByUser()+".pdf"+" on: " + formattedDate+"\n");
     fileWriter.close();

     return null;
 }



}
