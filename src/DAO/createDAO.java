package DAO;

import com.sun.xml.internal.bind.v2.TODO;
import servlets.writeInTableServlet;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
/**
 * Created by Vlad on 24.10.2016.
 */

public class createDAO {

    private static String url = "jdbc:mysql://localhost:3306/belarus";
    private static String username = "root";
    private static String password = "root";



    /** зафигачить волшебный MERGE на create и update    --->   совпало - update, не совпало - insert (не факт что отпашет)**/



    public static void createRow(String townID, String townName, String townURL) {
        try
        {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            writeInTableServlet.message = "DAO.createDAO ---> try";
            Statement statement = connection.createStatement() ;
            String sql = "INSERT INTO towns " +
                    "VALUES ("+Integer.parseInt(townID)+ ", '"+townName+"', '"+townURL+"')";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        }
        catch (SQLException | ClassNotFoundException e){e.printStackTrace();
            writeInTableServlet.message = "DAO.createDAO ---> catch";}
    }
}
