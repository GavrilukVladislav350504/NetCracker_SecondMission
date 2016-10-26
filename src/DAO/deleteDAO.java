package DAO;

import servlets.deleteServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Vlad on 24.10.2016.
 */
public class deleteDAO {

    private static String url = "jdbc:mysql://localhost:3306/belarus";
    private static String username = "root";
    private static String password = "root";

    public void deleteRow(String townID) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            deleteServlet.message = "deleteDAO ---> try";
            Statement statement = connection.createStatement() ;
            String sql = "DELETE FROM towns WHERE id = " + Integer.parseInt(townID);
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            deleteServlet.message = "deleteDAO --> catch";
            }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
}
