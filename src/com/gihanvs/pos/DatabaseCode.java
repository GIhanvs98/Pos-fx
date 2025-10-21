package com.gihanvs.pos;

import com.gihanvs.pos.db.DbConnection;
import com.gihanvs.pos.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseCode {
    public  static boolean registerUser(User user) throws ClassNotFoundException, SQLException {
        Connection conn = DbConnection.getConnection().getInstance();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO user VALUES (?,?,?,?,?)");
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getEmail());
        ps.setString(3,user.getDisplayName());
        ps.setString(4, user.getContactNumber());
        ps.setString(5, user.getPassword());
        return ps.executeUpdate()>0;
    }
}
