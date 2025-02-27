
package LMS;
// Including Header Files.
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Types;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Library {
    private String name; 
    public static Librarian librarian; 
    public static ArrayList<Person> persons; 

    private static Library instance; 

    private Library() {
        name = null;
        librarian = null;
        persons = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    // Library Information
    public void setName(String n) { name = n; }
    public String getLibraryName() { return name; }

    // Librarian Management
    public static boolean addLibrarian(Librarian lib) {
        if (librarian == null) {
            librarian = lib;
            persons.add(librarian);
            return true;
        }
        System.out.println("\nSorry, the library already has a librarian.");
        return false;
    }

    public Librarian getLibrarian() { return librarian; }
}   
