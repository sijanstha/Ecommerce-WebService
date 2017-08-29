package com.ecommerce.dbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CMNFunctions {

    public Connection con = new DBConnection().getConnection();
    public ResultSet rs;
    public int sts;
    public String msg = "";

    public CMNFunctions executeStoredProcedure(String sql) {
        CMNFunctions objCMNFunctions = new CMNFunctions();

        try {
            Statement st = con.createStatement();
            objCMNFunctions.sts = 0;
            objCMNFunctions.rs = st.executeQuery(sql);

        } catch (SQLException ex) {
            objCMNFunctions.sts = 1;
            objCMNFunctions.msg = ex.toString();
        }
        return objCMNFunctions;
    }
}
