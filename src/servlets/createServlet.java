package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;




/**
 * Created by Vlad on 22.10.2016.
 */
@WebServlet(name = "createServlet",urlPatterns = "/servlets/createServlet/")

public class createServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {



        request.getSession().setAttribute("submitName", "");
        request.getSession().setAttribute("name", "");
        request.getSession().setAttribute("url", "");

        response.sendRedirect("http://localhost:8080/NetCracker_SecondMission_war_exploded/webStructures/updateJSP.jsp");
    }


    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    }
}