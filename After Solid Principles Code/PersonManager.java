
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import LMS.Borrower;
import LMS.Clerk;
import LMS.Librarian;
import LMS.Library;
import LMS.Person;
/*CREATED NEW CLASS TO MANAGE FINDING BORRWERS AND CLERKS TAKEN FROM LIBRARY CLASS */
public class PersonManager {

    public void createPerson(char type) {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.println("\nEnter Name:");
            String name = reader.readLine();
            System.out.println("Enter Address:");
            String address = reader.readLine();
            System.out.println("Enter Phone Number:");
            int phone = sc.nextInt();
            
            if (type == 'c' || type == 'l') {
                System.out.println("Enter Salary:");
                double salary = sc.nextDouble();
                if (type == 'c') {
                    Clerk clerk = new Clerk(-1, name, address, phone, salary, -1);
                    System.out.println("\nClerk " + name + " created successfully.");
                } else {
                    Librarian librarian = new Librarian(-1, name, address, phone, salary, -1);
                    System.out.println("\nLibrarian " + name + " created successfully.");
                }
            } else {
                Borrower borrower = new Borrower(-1, name, address, phone);
                System.out.println("\nBorrower " + name + " created successfully.");
            }
        } catch (IOException e) {
            Logger.getLogger(PersonManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    public Borrower findBorrower() {
        System.out.println("\nEnter Borrower's ID: ");
        int id = new Scanner(System.in).nextInt();

        for (Person person : Library.getInstance().getPersons()) {
            if (person instanceof Borrower && person.getID() == id) {
                return (Borrower) person;
            }
        }

        System.out.println("\nBorrower not found.");
        return null;
    }

    public Clerk findClerk() {
        System.out.println("\nEnter Clerk's ID: ");
        int id = new Scanner(System.in).nextInt();

        for (Person person : Library.getInstance().getPersons()) {
            if (person instanceof Clerk && person.getID() == id) {
                return (Clerk) person;
            }
        }

        System.out.println("\nClerk not found.");
        return null;
    }
}
