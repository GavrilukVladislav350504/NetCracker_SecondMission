package DAO;

import servlets.writeInTableServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Vlad on 24.10.2016.
 */
public class updateDAO {

    private static String url = "jdbc:mysql://localhost:3306/belarus";
    private static String username = "root";
    private static String password = "root";

    public static void updateRow(String townID, String townName, String townURL) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            writeInTableServlet.message = "DAO.updateDAO ---> try";
            Statement statement = connection.createStatement();
            String sql = "UPDATE towns " +
                    "SET  town_name = '" + townName + "' , url_name = '" + townURL + " ' WHERE id = " + Integer.parseInt(townID);
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            writeInTableServlet.message = "DAO.updateDAO ---> catch";
        }
    }
}
