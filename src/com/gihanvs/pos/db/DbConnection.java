package com.gihanvs.pos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection=null;
    private final Connection connection;
    private DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
       this.connection =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/pos_system_dsmp6","root","1234");
    }
    public static DbConnection getConnection() throws SQLException, ClassNotFoundException {
        if (dbConnection==null) {
          dbConnection=new DbConnection();
        }
        return dbConnection;
    }
    public Connection getInstance(){
        return connection;
    }

}
