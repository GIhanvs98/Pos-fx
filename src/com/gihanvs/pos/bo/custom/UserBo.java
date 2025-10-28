package com.gihanvs.pos.bo.custom;

import com.gihanvs.pos.dto.request.RequestUserDto;
import com.gihanvs.pos.dto.response.ResponseUserDto;

public interface UserBo {
    public boolean registeruser(RequestUserDto requestUserDto);
    public ResponseUserDto login( String email, String password);
}
