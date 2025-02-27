public class LibraryDataSaver {
    private Connection con;

    public LibraryDataSaver(Connection con) {
        this.con = con;
    }

    public void clearDatabase() throws SQLException {
        String[] tables = {"LOAN", "BORROWED_BOOK", "ON_HOLD_BOOK", "BOOK", "CLERK", "LIBRARIAN", "BORROWER", "STAFF", "PERSON"};
        for (String table : tables) {
            String sql = "DELETE FROM LIBRARY." + table;
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.executeUpdate();
            }
        }
    }

    public void saveLibraryData(Library lib, ArrayList<Loan> loans) throws SQLException {
        savePersons(lib);
        saveStaff(lib);
        saveBorrowers(lib);
        saveBooks(lib.getBooks());
        saveLoans(loans);
        saveHoldRequests(lib.getBooks());
        saveBorrowedBooks(lib, loans);
    }

    private void savePersons(Library lib) throws SQLException {
        String sql = "INSERT INTO LIBRARY.PERSON (ID, PNAME, PASSWORD, ADDRESS, PHONE_NO) values (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            for (Person person : lib.getPersons()) {
                stmt.setInt(1, person.getID());
                stmt.setString(2, person.getName());
                stmt.setString(3, person.getPassword());
                stmt.setString(4, person.getAddress());
                stmt.setInt(5, person.getPhoneNumber());
                stmt.executeUpdate();
            }
        }
    }

    private void saveStaff(Library lib) throws SQLException {
        for (Person person : lib.getPersons()) {
            if (person instanceof Clerk) {
                saveClerk((Clerk) person);
            }
        }
        if (lib.getLibrarian() != null) {
            saveLibrarian(lib.getLibrarian());
        }
    }

    private void saveClerk(Clerk clerk) throws SQLException {
        String sqlStaff = "INSERT INTO LIBRARY.STAFF (S_ID, TYPE, SALARY) values (?, ?, ?)";
        String sqlClerk = "INSERT INTO LIBRARY.CLERK (C_ID, DESK_NO) values (?, ?)";
        try (PreparedStatement stmtStaff = con.prepareStatement(sqlStaff);
             PreparedStatement stmtClerk = con.prepareStatement(sqlClerk)) {
            stmtStaff.setInt(1, clerk.getID());
            stmtStaff.setString(2, "Clerk");
            stmtStaff.setDouble(3, clerk.getSalary());
            stmtStaff.executeUpdate();
            stmtClerk.setInt(1, clerk.getID());
            stmtClerk.setInt(2, clerk.deskNo);
            stmtClerk.executeUpdate();
        }
    }

    private void saveLibrarian(Librarian librarian) throws SQLException {
        String sqlStaff = "INSERT INTO LIBRARY.STAFF (S_ID, TYPE, SALARY) values (?, ?, ?)";
        String sqlLibrarian = "INSERT INTO LIBRARY.LIBRARIAN (L_ID, OFFICE_NO) values (?, ?)";
        try (PreparedStatement stmtStaff = con.prepareStatement(sqlStaff);
             PreparedStatement stmtLibrarian = con.prepareStatement(sqlLibrarian)) {
            stmtStaff.setInt(1, librarian.getID());
            stmtStaff.setString(2, "Librarian");
            stmtStaff.setDouble(3, librarian.getSalary());
            stmtStaff.executeUpdate();
            stmtLibrarian.setInt(1, librarian.getID());
            stmtLibrarian.setInt(2, librarian.officeNo);
            stmtLibrarian.executeUpdate();
        }
    }

    private void saveBorrowers(Library lib) throws SQLException {
        String sql = "INSERT INTO LIBRARY.BORROWER (B_ID) values (?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            for (Person person : lib.getPersons()) {
                if (person instanceof Borrower) {
                    stmt.setInt(1, person.getID());
                    stmt.executeUpdate();
                }
            }
        }
    }

    private void saveBooks(ArrayList<Book> books) throws SQLException {
        String sql = "INSERT INTO LIBRARY.BOOK (ID, TITLE, AUTHOR, SUBJECT, IS_ISSUED) values (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            for (Book book : books) {
                stmt.setInt(1, book.getID());
                stmt.setString(2, book.getTitle());
                stmt.setString(3, book.getAuthor());
                stmt.setString(4, book.getSubject());
                stmt.setBoolean(5, book.getIssuedStatus());
                stmt.executeUpdate();
            }
        }
    }

    private void saveLoans(ArrayList<Loan> loans) throws SQLException {
        String sql = "INSERT INTO LIBRARY.LOAN (L_ID, BORROWER, BOOK, ISSUER, ISS_DATE, RECEIVER, RET_DATE, FINE_PAID) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            int i = 1;
            for (Loan loan : loans) {
                stmt.setInt(1, i++);
                stmt.setInt(2, loan.getBorrower().getID());
                stmt.setInt(3, loan.getBook().getID());
                stmt.setInt(4, loan.getIssuer().getID());
                stmt.setTimestamp(5, new java.sql.Timestamp(loan.getIssuedDate().getTime()));
                stmt.setBoolean(8, loan.getFineStatus());
                if (loan.getReceiver() == null) {
                    stmt.setNull(6, Types.INTEGER);
                    stmt.setNull(7, Types.TIMESTAMP);
                } else {
                    stmt.setInt(6, loan.getReceiver().getID());
                    stmt.setTimestamp(7, new java.sql.Timestamp(loan.getReturnDate().getTime()));
                }
                stmt.executeUpdate();
            }
        }
    }

    private void saveHoldRequests(ArrayList<Book> books) throws SQLException {
        String sql = "INSERT INTO LIBRARY.ON_HOLD_BOOK (REQ_ID, BOOK, BORROWER, REQ_DATE) values (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            int x = 1;
            for (Book book : books) {
                for (HoldRequest request : book.getHoldRequests()) {
                    stmt.setInt(1, x++);
                    stmt.setInt(2, request.getBook().getID());
                    stmt.setInt(3, request.getBorrower().getID());
                    stmt.setDate(4, new java.sql.Date(request.getRequestDate().getTime()));
                    stmt.executeUpdate();
                }
            }
        }
    }

    private void saveBorrowedBooks(Library lib, ArrayList<Loan> loans) throws SQLException {
        String sql = "INSERT INTO LIBRARY.BORROWED_BOOK (BOOK, BORROWER) values (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            for (Loan loan : loans) {
                if (loan.getReceiver() == null) {
                    stmt.setInt(1, loan.getBook().getID());
                    stmt.setInt(2, loan.getBorrower().getID());
                    stmt.executeUpdate();
                }
            }
        }
    }
}
