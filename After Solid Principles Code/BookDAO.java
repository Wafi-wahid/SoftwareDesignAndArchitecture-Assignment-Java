public class BookDAO {
    private Connection con;

    public BookDAO(Connection con) {
        this.con = con;
    }

    public List<Book> fetchBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String SQL = "SELECT * FROM BOOK";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                books.add(new Book(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("SUBJECT"),
                                   rs.getString("AUTHOR"), rs.getBoolean("IS_ISSUED")));
            }
        }
        return books;
    }
}
