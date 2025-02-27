public class DatabaseHelper {
    public static Connection getConnection() {
        try {
            String host = "jdbc:derby://localhost:1527/LMS";
            String uName = "haris";
            String uPass = "123";
            return DriverManager.getConnection(host, uName, uPass);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
            return null;
        }
    }
}
