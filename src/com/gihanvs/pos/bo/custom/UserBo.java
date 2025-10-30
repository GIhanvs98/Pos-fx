package com.gihanvs.pos.bo.custom;

import com.gihanvs.pos.bo.SuperBo;
import com.gihanvs.pos.dto.request.RequestUserDto;
import com.gihanvs.pos.dto.response.ResponseUserDto;

import java.sql.SQLException;

public interface UserBo extends SuperBo {
    public boolean registeruser(RequestUserDto requestUserDto) throws SQLException, ClassNotFoundException;
    public ResponseUserDto login( String email, String password) throws SQLException, ClassNotFoundException;
}
