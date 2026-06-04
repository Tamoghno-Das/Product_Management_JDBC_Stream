package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil
{
    public static Connection getConnection()
    {
        Connection connection = null;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "c##scott", "tiger");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return connection;
    }
}
