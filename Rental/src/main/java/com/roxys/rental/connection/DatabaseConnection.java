package com.roxys.rental.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection createConnection() throws SQLException {
        Connection con =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/roxys", "roxys", "roxys");
        return con;
    }
}
