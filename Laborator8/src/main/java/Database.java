import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/map";
    private static final String USER = "root";
    private static final String PASSWORD = "Nicsan1234567890.";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        if (connection == null)
            createConnection();
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
