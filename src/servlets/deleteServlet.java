package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Vlad on 24.10.2016.
 */
@WebServlet(name = "deleteServlet",urlPatterns = "/servlets/deleteServlet/")

public class deleteServlet extends HttpServlet {

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


        /**
         *
         * BL.releaseBLdelete --> DAO.deleting
         *
         * **/

        response.sendRedirect("http://localhost:8080/NetCracker_SecondMission_war_exploded/index.xhtml");
    }


    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    }
}