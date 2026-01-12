package com.gihanvs.pos.dao.custom.impl;

import com.gihanvs.pos.dao.CrudUtill;
import com.gihanvs.pos.dao.custom.UserDao;
import com.gihanvs.pos.entity.Customer;
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
    public User findByEmail(String email) throws SQLException, ClassNotFoundException {

        ResultSet rs = CrudUtill.execute("SELECT * FROM user WHERE email = ?",email);
        if (rs.next()) {
            return new User(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
            );


        }else {
            return null;
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
    public User findById(String s) {
    return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
