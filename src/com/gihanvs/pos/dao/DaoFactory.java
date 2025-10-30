package com.gihanvs.pos.dao;

import com.gihanvs.pos.dao.custom.UserDao;
import com.gihanvs.pos.dao.custom.impl.UserDaoImpl;
import com.gihanvs.pos.utill.DaoType;

public class DaoFactory {
    private static DaoFactory daoFactory=null;
    private DaoFactory(){}
    public static DaoFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DaoFactory();
        }
        return daoFactory;
    }
    public  <T>T getDao(DaoType daoType){
        switch (daoType){
            case USER:
                return(T) new UserDaoImpl();

                default:return null;
        }

    }
}
