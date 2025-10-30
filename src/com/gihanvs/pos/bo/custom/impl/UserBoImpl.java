package com.gihanvs.pos.bo.custom.impl;

import com.gihanvs.pos.bo.custom.UserBo;
import com.gihanvs.pos.dao.DaoFactory;
import com.gihanvs.pos.dao.custom.UserDao;
import com.gihanvs.pos.dto.request.RequestUserDto;
import com.gihanvs.pos.dto.response.ResponseUserDto;
import com.gihanvs.pos.entity.User;
import com.gihanvs.pos.utill.DaoType;
import com.gihanvs.pos.utill.PasswordHash;

import java.sql.SQLException;
import java.util.UUID;

public class UserBoImpl implements UserBo {
    private UserDao userDao=  DaoFactory.getInstance().getDao(DaoType.USER);
    @Override
    public boolean registeruser(RequestUserDto requestUserDto) throws SQLException, ClassNotFoundException {

      return userDao.save( new User(
               UUID.randomUUID().toString(),
               requestUserDto.getEmail(),
               requestUserDto.getDisplayName(),
               requestUserDto.getContactNumber(),
               requestUserDto.getPassword()));
    }

    @Override
    public ResponseUserDto login(String email, String password) throws SQLException, ClassNotFoundException {
            User selectedUser=userDao.findByEmail(email);
            if(selectedUser!=null){
                if(PasswordHash.checkPassword(password,selectedUser.getPassword())){
                    return new ResponseUserDto(
                            selectedUser.getDisplayName(),
                            selectedUser.getContactNumber(),
                            200,
                            "Login success",
                            selectedUser.getEmail(),
                            true);
                }else{
                    return new ResponseUserDto(
                            null,
                            null,
                            401,
                            "Incorrect Password",
                            null,
                            false);
                }
            }
            return null;

    }
}
