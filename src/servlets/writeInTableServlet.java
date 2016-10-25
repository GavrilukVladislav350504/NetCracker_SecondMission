package servlets;

import BL.releaseBLcreate;
import BL.releaseBLupdate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Vlad on 24.10.2016.
 */
@WebServlet(name = "writeInTableServlet", urlPatterns = "/servlets/writeInTableServlet/")

public class writeInTableServlet extends HttpServlet {
    public static String message = "start value";

    private static boolean flagInsertOrUpdate;

    public static boolean isFlagInsertOrUpdate() {
        return flagInsertOrUpdate;
    }

    public static void setFlagInsertOrUpdate(boolean flagInsertOrUpdate) {
        writeInTableServlet.flagInsertOrUpdate = flagInsertOrUpdate;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String inputID = request.getParameter("inputID");
        String inputName = request.getParameter("inputTownName");
        String inputURL = request.getParameter("inputURL");
        response.setContentType("text/html");

        if (isFlagInsertOrUpdate())
            releaseBLcreate.creating(inputID, inputName, inputURL);
        else
            releaseBLupdate.updating(inputID,inputName,inputURL);

        request.getSession().setAttribute("message", message);
        response.sendRedirect("http://localhost:8080/NetCracker_SecondMission_war_exploded/index.xhtml");
    }


    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    }
}