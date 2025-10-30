package com.gihanvs.pos.bo;

import com.gihanvs.pos.bo.custom.impl.UserBoImpl;
import com.gihanvs.pos.utill.BoType;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {}
    public static BoFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }
    public <T>T getBoFactory(BoType boType) {
        switch (boType) {
            case USER:
                return(T) new UserBoImpl();
            default:
                return null;
        }
    }
}
