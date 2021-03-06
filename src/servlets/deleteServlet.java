package servlets;

import BL.releaseBLdelete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vlad on 24.10.2016.
 */
@WebServlet(name = "deleteServlet", urlPatterns = "/servlets/deleteServlet/")

public class deleteServlet extends HttpServlet {
    public static String message = "start value";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String numberID = request.getParameter("deleteButton");
        response.setContentType("text/html");
        releaseBLdelete.deleting(numberID);

        request.getSession().setAttribute("message", message);
        response.sendRedirect("http://localhost:8080/NetCracker_SecondMission_war_exploded/index.xhtml");

    }


    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    }
}