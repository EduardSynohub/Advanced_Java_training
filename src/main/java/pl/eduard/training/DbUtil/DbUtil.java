package pl.eduard.training.DbUtil;

import java.sql.*;

public class DbUtil {
    public static final String DB_ADDRESS = "jdbc:mysql://localhost:3306/";
    public static final String DB_PARAMS = "?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    public static final String DB_DEFAULT = "newsletterDB";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "";

    public static Connection connect() throws SQLException {
        return connect(DB_DEFAULT);
    }

    public static Connection connect(String dbName) throws SQLException {
        String dbUrl = DB_ADDRESS + dbName + DB_PARAMS;
        return DriverManager.getConnection(dbUrl, DB_USER, DB_PASS);
    }

    public static void saveUser(String email, String name) {
        String query = "INSERT INTO newsletter(userEmail, userName) VALUES(?, ?)";

        try (Connection connection = connect(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setString(2, name);

            int res = ps.executeUpdate();

            System.out.println("Result: " + res);
        } catch (SQLException e) {
            System.out.println("SQL error: " + e);
        }
    }
}
