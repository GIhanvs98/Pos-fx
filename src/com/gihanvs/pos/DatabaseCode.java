package com.gihanvs.pos;

import com.gihanvs.pos.db.DbConnection;
import com.gihanvs.pos.model.LoginData;
import com.gihanvs.pos.model.User;
import com.gihanvs.pos.utill.CrudUtill;
import com.gihanvs.pos.utill.PasswordHash;

import java.sql.*;

public class DatabaseCode {
    public  static boolean registerUser(User user) throws ClassNotFoundException, SQLException {
            return CrudUtill.execute("INSERT INTO user VALUES (?,?,?,?,?)",user.getUserId(),user.getEmail(),user.getDisplayName(),user.getContactNumber(),user.getPassword());
    }
    public static LoginData loginUser(String email,String rowPassord) throws ClassNotFoundException, SQLException {

        ResultSet rs = CrudUtill.execute("SELECT * FROM user WHERE email = ?",email);
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
