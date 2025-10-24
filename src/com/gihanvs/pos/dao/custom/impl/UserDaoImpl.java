package com.gihanvs.pos.dao.custom.impl;

import com.gihanvs.pos.dao.CrudUtill;
import com.gihanvs.pos.dao.custom.UserDao;
import com.gihanvs.pos.entity.User;
import com.gihanvs.pos.model.LoginData;
import com.gihanvs.pos.utill.PasswordHash;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findByName(String name) {
        return List.of();
    }

    @Override
    public LoginData findByEmail(String email,String password) throws SQLException, ClassNotFoundException {

        ResultSet rs = CrudUtill.execute("SELECT * FROM user WHERE email = ?",email);
        if (rs.next()) {
            String userEmail = rs.getString("email");
            String hashedPassword = rs.getString("password");
            String displayName = rs.getString("display_name");

            if (PasswordHash.checkPassword(password,hashedPassword)) {
                return new LoginData(200,"success",userEmail,displayName,true);
            }else {
                return new LoginData(401,"Wrong Password",null,null,false);
            }
        }else {
            return new LoginData(404,"User not found",null,null,false);
        }
    }

    @Override
    public boolean save(User user) throws SQLException, ClassNotFoundException {
        return CrudUtill.execute("INSERT INTO user VALUES (?,?,?,?,?)",user.getUserId(),user.getEmail(),user.getDisplayName(),user.getContactNumber(),user.getPassword());
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public String findById(String s) {
        return "";
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
