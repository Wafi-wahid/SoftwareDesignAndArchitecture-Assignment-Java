
import java.util.ArrayList;
import java.util.Scanner;
/*NEW CLASS CREATED TO HANDLE THE REMOVING AND ADDING BOOKS METHOD TAKEN FROM LIBRARY CLASSS */
public class BookManager {
    private ArrayList<Book> booksInLibrary = new ArrayList<>();

    public void addBook(Book book) {
        booksInLibrary.add(book);
    }

    public void removeBook(Book book) {
        boolean delete = true;

        for (Person person : Library.getInstance().getPersons()) {
            if (person instanceof Borrower) {
                ArrayList<Loan> borrowedBooks = ((Borrower) person).getBorrowedBooks();
                for (Loan loan : borrowedBooks) {
                    if (loan.getBook() == book) {
                        delete = false;
                        System.out.println("Book is currently borrowed.");
                        break;
                    }
                }
            }
        }

        if (delete) {
            System.out.println("Removing book...");
            booksInLibrary.remove(book);
            System.out.println("Book removed.");
        } else {
            System.out.println("Delete Unsuccessful.");
        }
    }

    public ArrayList<Book> getBooks() {
        return booksInLibrary;
    }
}
