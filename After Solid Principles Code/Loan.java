package LMS;

import java.util.Date;

public class Loan {
    private Borrower borrower;
    private Book book;
    private Staff issuer;
    private Date issuedDate;
    private Date dateReturned;
    private Staff receiver;

    public Loan(Borrower bor, Book b, Staff i, Date iDate) {
        this.borrower = bor;
        this.book = b;
        this.issuer = i;
        this.issuedDate = iDate;
        this.dateReturned = null; // Initially null until book is returned
        this.receiver = null;
    }

    // Getter methods
    public Book getBook() { return book; }
    public Staff getIssuer() { return issuer; }
    public Staff getReceiver() { return receiver; }
    public Date getIssuedDate() { return issuedDate; }
    public Date getReturnDate() { return dateReturned; }
    public Borrower getBorrower() { return borrower; }
}
