package BL;

import DAO.selectDAO;

import java.io.IOException;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Vlad on 26.10.2016.
 */
public class releaseBLselect implements selectBL {
    public static void selectALL (String ID,String column){
        DAO.selectDAO.selectAll_DAO();
    }

    public static String selectColumnByID (String ID,String column) throws IOException {
        selectDAO select = new selectDAO();
        String result = select.selectColumnByID_DAO(ID,column);
        return result;
    }
}
