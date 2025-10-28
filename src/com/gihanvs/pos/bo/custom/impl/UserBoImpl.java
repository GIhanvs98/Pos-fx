package com.gihanvs.pos.bo.custom.impl;

import com.gihanvs.pos.bo.custom.UserBo;
import com.gihanvs.pos.dto.request.RequestUserDto;
import com.gihanvs.pos.dto.response.ResponseUserDto;

public class UserBoImpl implements UserBo {
    @Override
    public boolean registeruser(RequestUserDto requestUserDto) {
        return false;
    }

    @Override
    public ResponseUserDto login(String email, String password) {
        return null;
    }
}
