package BL;

import DAO.deleteDAO;
import servlets.deleteServlet;

/**
 * Created by Vlad on 24.10.2016.
 */
public class releaseBLdelete implements deleteBL {
    public static void deleting(String townID) {
        deleteServlet.message = "in BL";
        deleteDAO.deleteRow(townID);
    }
}
