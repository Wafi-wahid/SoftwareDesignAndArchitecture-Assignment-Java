import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/*NEW CLASS CREATED TO HANDLE  CHANGING BOOK INFO METHOD  TAKEN FROM BOOK CLASS */
public class ChangeBookInfo {
     public void changeBookInfo() throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("\nUpdate Author? (y/n)");
        if (scanner.next().equals("y")) {
            System.out.println("\nEnter new Author: ");
            author = reader.readLine();
        }
        
        System.out.println("\nUpdate Subject? (y/n)");
        if (scanner.next().equals("y")) {
            System.out.println("\nEnter new Subject: ");
            subject = reader.readLine();
        }
        
        System.out.println("\nUpdate Title? (y/n)");
        if (scanner.next().equals("y")) {
            System.out.println("\nEnter new Title: ");
            title = reader.readLine();
        }
        
        System.out.println("\nBook is successfully updated.");
    }
}
