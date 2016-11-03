package sumptus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Make the connection with the Database
 * @author Jessica Dagostini
 */
public class DataBase {
    public static Connection connection() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sumptus", "postgres", "senha");
        conn.setAutoCommit(false);
        return conn;
    }
}
