
import java.util.ArrayList;
import java.util.Date;

import LMS.Borrower;
import LMS.Loan;
 /*CREATED TO MANGAE THE LOANS METHODS TAKEN FROM LIBRARY CLASS */
public class LoanManager {
    private ArrayList<Loan> loans = new ArrayList<>();

    public void addLoan(Loan loan) {
        loans.add(loan);
    }
/******taken the method from library class */
    public void renewIssuedBook(Loan loan, Date newIssueDate) {
        loan.setReturnedDate(newIssueDate);
        System.out.println("Book deadline extended!");
    }
     public double computeFine(Borrower borrower) {
        double totalFine = 0;
        for (Loan l : loans) {
            if (l.getBorrower().equals(borrower)) {
                totalFine += l.computeFine1();
            }
        }
        return totalFine;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }
}
