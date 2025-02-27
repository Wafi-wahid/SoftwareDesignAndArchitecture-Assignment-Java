// LibraryDataLoader.java - Responsible for populating library data from the database
public class LibraryDataLoader {
    private Connection con;
    private BookDAO bookDAO;
    private ClerkDAO clerkDAO;
    private LibrarianDAO librarianDAO;
    private BorrowerDAO borrowerDAO;
    private LoanDAO loanDAO;
    
    public LibraryDataLoader(Connection con) {
        this.con = con;
        this.bookDAO = new BookDAO(con);
        this.clerkDAO = new ClerkDAO(con);
        this.librarianDAO = new LibrarianDAO(con);
        this.borrowerDAO = new BorrowerDAO(con);
        this.loanDAO = new LoanDAO(con);
    }
    
    public void populateLibrary(Library library) throws SQLException {
        library.setBooks(bookDAO.fetchBooks());
        library.setClerks(clerkDAO.fetchClerks());
        library.setLibrarians(librarianDAO.fetchLibrarians());
        library.setBorrowers(borrowerDAO.fetchBorrowers());
        library.setLoans(loanDAO.fetchLoans(library));
    }
}
