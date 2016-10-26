package DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Vlad on 26.10.2016.
 */
public class selectDAO {

    private static String url = "jdbc:mysql://localhost:3306/belarus";
    private static String username = "root";
    private static String password = "root";

    public static void selectAll_DAO(){}

    public String selectColumnByID_DAO(String ID, String columnName) throws IOException {

        /*FileInputStream fis;
        Properties property = new Properties();*/
        /**
         * Can't find DB.properties
         * */
        String result = null;
        try {

            /*
            fis = new FileInputStream("resources/DAO.DB.properties");
            property.load(getClass().getResourceAsStream("resources/DB.properties"));

            String url = property.getProperty("url");
            String username = property.getProperty("username");
            String password = property.getProperty("password");
            */

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);

            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select * from towns WHERE id = " + ID);
            while (resultset.next()) {
                result = resultset.getString(columnName);
            }

            resultset.close();
            statement.close();
            connection.close();

            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
