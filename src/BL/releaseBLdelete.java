package BL;

import DAO.deleteDAO;

/**
 * Created by Vlad on 24.10.2016.
 */
public class releaseBLdelete implements deleteBL {
    public static void deleting(String townID) {
        deleteDAO delete = new deleteDAO();
        delete.deleteRow(townID);
    }
}
