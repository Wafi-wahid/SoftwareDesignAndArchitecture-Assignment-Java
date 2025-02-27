import java.util.ArrayList;

import LMS.HoldRequest;
//*******A NEW BorrowedOperations CLASS CREATED TO HANDLE THE FOLLOWING RESPONSIBILITY FROM THE BORROWER CLASS*/
public class BorrowedOperations {
      
      /*-- Adding and Removing from Borrowed Books---*/
    public void addBorrowedBook(Loan iBook)
    {
        borrowedBooks.add(iBook);
    }
    
    public void removeBorrowedBook(Loan iBook)
    {
        borrowedBooks.remove(iBook);
    }    
    
    /*-------------------------------------------*/
    
}


