package com.gihanvs.pos.dao.custom;

import com.gihanvs.pos.dao.CrudDao;
import com.gihanvs.pos.entity.User;
import com.gihanvs.pos.model.LoginData;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends CrudDao<User,String> {
   public List<User> findByName(String name);
   public LoginData findByEmail(String email,String password) throws SQLException, ClassNotFoundException;
}
