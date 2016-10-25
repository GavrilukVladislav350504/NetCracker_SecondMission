package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;



/**
 * Created by Vlad on 20.10.2016.
 */
@WebServlet(name = "updateServlet",urlPatterns = "/servlets/updateServlet/")

    public class updateServlet extends HttpServlet {

    private String url = "jdbc:mysql://localhost:3306/belarus";
    private String username = "root";
    private String password = "root";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String submitName = request.getParameter("changeButton");
        response.setContentType("text/html");
        String townName = null,townURL = null;

        /**вынести в метод**/

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url, username, password);

            Statement statement = connection.createStatement() ;
            ResultSet resultset = statement.executeQuery("select * from towns WHERE id = " + submitName) ;
            while (resultset.next())
            {
                townName = resultset.getString("town_name");
                townURL = resultset.getString("url_name");
            }

            resultset.close();
            statement.close();
            connection.close();
        }
        catch (SQLException | ClassNotFoundException e){e.printStackTrace();}

        request.getSession().setAttribute("submitName", submitName);
        request.getSession().setAttribute("name", townName);
        request.getSession().setAttribute("url", townURL);

        response.sendRedirect("http://localhost:8080/NetCracker_SecondMission_war_exploded/index.xhtml");
    }


    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    }
}