package com.ecommerce.dbconnection;

import java.sql.*;
import javax.servlet.*;

public class DBConnection {

    private Connection objConn = null;
    private String server = "110.44.116.71";
    private String user = "sa";
    private String pass = "X@mpP890";
    //private int port = 49991;
    private int port = 1433;
    private String dbName = "db_eCommerce";

    private String jdbcurl = "jdbc:sqlserver://" + server + ":" + port
            + ";user=" + user + ";password=" + pass + ";databasename=" + dbName + "";

    public Connection getConnection() {
       if(objConn == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                objConn = DriverManager.getConnection(jdbcurl);
                   
            } catch (Exception ex) {
                
            }

            return objConn;
        
    }else{
    return objConn;
}
   
}
}
