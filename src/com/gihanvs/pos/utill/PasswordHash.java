package com.gihanvs.pos.utill;

import org.mindrot.BCrypt;

public class PasswordHash {
    public  static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }
    public static boolean checkPassword(String password, String hashedPassword){
        return BCrypt.checkpw(password, hashedPassword);
    }
}
