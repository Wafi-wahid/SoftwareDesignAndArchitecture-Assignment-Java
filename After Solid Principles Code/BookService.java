//NEW CLASS BookService IS CREATED TO HANDLE THE makeholdrequest() METHOD OF BOOK.JAVA 

import LMS.Book;
import LMS.HoldRequestOperations;

public class BookService {
    public void makeHoldRequest(Borrower borrower, Book book, HoldRequestOperations holdRequestsOperations) {
    if (borrower.getBorrowedBooks().stream().anyMatch(loan -> loan.getBook().equals(book))) {
        System.out.println("\nYou have already borrowed " + book.getTitle());
        return;                
    }
    
    if (holdRequestsOperations.hasHoldRequest(borrower)) {
        System.out.println("\nYou already have one hold request for this book.\n");
    } else {
        holdRequestsOperations.placeBookOnHold(borrower, book);
    }
}

}
