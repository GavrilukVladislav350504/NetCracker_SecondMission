package BL;


import DAO.createDAO;


/**
 * Created by Vlad on 24.10.2016.
 */
public class releaseBLcreate implements createBL {
    public static void creating(String townID, String townName, String townURL) {
        createDAO create = new createDAO();
        create.createRow(townID, townName, townURL);
    }
}
