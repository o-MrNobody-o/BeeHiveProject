package utility;

import java.sql.Connection;

public class DBTest 
{
    public static void main(String[] args) 
    {
        Connection conn = DBConnection.getConnection();
        if (conn != null) 
        {
            System.out.println("✅ Test successful: Connection is established.");
        } 
        else 
        {
            System.out.println("❌ Test failed: Connection is null.");
        }
    }
}
