package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
    private static final String URL = "jdbc:mysql://localhost:3306/smartbeehousedb"; 
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    private static Connection connection = null;

    private DBConnection() 
    {
    }

    public static Connection getConnection() 
    {
        if (connection == null) 
        {
            try 
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connection established successfully");
            } 
            catch (ClassNotFoundException | SQLException e) 
            {
            	System.err.println("Failed to connect to the database");
                e.printStackTrace();
                throw new RuntimeException("Database connection failed");
            }
        }
        return connection;
    }
}
