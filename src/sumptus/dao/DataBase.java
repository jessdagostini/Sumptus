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
        //Connection conn = DriverManager.getConnection("jdbc:postgresql://lrdrkblc:bdY0kH83M_T7_bFvEhRkvzbXQgzeOwfN@elmer.db.elephantsql.com:5432/lrdrkblc", "lrdrkblc", "bdY0kH83M_T7_bFvEhRkvzbXQgzeOwfN");
        conn.setAutoCommit(false);
        return conn;
    }
}
