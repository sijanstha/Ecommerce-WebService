package com.ecommerce.dbconnection;

import java.sql.*;
import javax.servlet.*;

public class DBConnection {

    private Connection objConn = null;
    //initialize the server name of SQL Server
    private String server = "";
    private String user = "sa";
    //password for SQL server
    private String pass = "";
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
