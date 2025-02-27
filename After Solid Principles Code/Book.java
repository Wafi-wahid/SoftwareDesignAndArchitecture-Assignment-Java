package LMS;

import java.io.*;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Book {
    private int bookID;
    private String title;
    private String subject;
    private String author;
    private boolean isIssued;
    static int currentIdNumber = 0;
    
    public Book(int id, String t, String s, String a, boolean issued) {
        currentIdNumber++;
        bookID = (id == -1) ? currentIdNumber : id;
        title = t;
        subject = s;
        author = a;
        isIssued = issued;
    }

    public void printInfo() {
        System.out.println(title + "\t\t\t" + author + "\t\t\t" + subject);
    }
    
   
    
    public String getTitle() { return title; }
    public String getSubject() { return subject; }
    public String getAuthor() { return author; }
    public boolean getIssuedStatus() { return isIssued; }
    public void setIssuedStatus(boolean s) { isIssued = s; }
    public int getID() { return bookID; }
    public static void setIDCount(int n) { currentIdNumber = n; }
}
