package BL;

import DAO.updateDAO;

/**
 * Created by Vlad on 24.10.2016.
 */
public class releaseBLupdate implements updateBL {
    public static void updating(String townID, String townName, String townURL) {
        updateDAO update = new updateDAO();
        update.updateRow(townID, townName, townURL);
    }
}
