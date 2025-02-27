public class BookMapper {
    public static Book map(ResultSet rs) throws SQLException {
        return new Book(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("SUBJECT"),
                        rs.getString("AUTHOR"), rs.getBoolean("IS_ISSUED"));
    }
}
