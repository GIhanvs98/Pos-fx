package com.gihanvs.pos;

import com.gihanvs.pos.db.DbConnection;
import com.gihanvs.pos.model.LoginData;
import com.gihanvs.pos.model.User;
import com.gihanvs.pos.utill.PasswordHash;

import java.sql.*;

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
    public static LoginData loginUser(String email,String rowPassord) throws ClassNotFoundException, SQLException {

        Connection conn = DbConnection.getConnection().getInstance();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String userEmail = rs.getString("email");
            String hashedPassword = rs.getString("password");
            String displayName = rs.getString("display_name");

            if (PasswordHash.checkPassword(rowPassord,hashedPassword)) {
                return new LoginData(200,"success",userEmail,displayName,true);
            }else {
                return new LoginData(401,"Wrong Password",null,null,false);
            }
        }else {
            return new LoginData(404,"User not found",null,null,false);
        }
    }
}
