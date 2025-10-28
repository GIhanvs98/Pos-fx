package com.gihanvs.pos.dao.custom.impl;


import com.gihanvs.pos.dao.custom.UserDao;
import com.gihanvs.pos.entity.User;
import com.gihanvs.pos.utill.PasswordHash;

import java.sql.SQLException;
import java.util.UUID;

class UserDaoImplTest {

    void findByEmail() {
    }

    void save() {
        UserDao  userDao = new UserDaoImpl();
        User user = new User(
                UUID.randomUUID().toString(),
                "test@email.com",
                "test user",
                "07123565",
                PasswordHash.hashPassword("1234")
        );
        try {
            boolean isSaved = userDao.save(user);
            if(isSaved) System.out.println("User has been saved");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        UserDaoImplTest test = new UserDaoImplTest();
        test.save();
    }
}