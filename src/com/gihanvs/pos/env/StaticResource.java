package com.gihanvs.pos.env;

public class StaticResource {
    private final static String VERSION="1.0";
    private final static String COMPANY="gihanvs";
    public static String getVERSION() {
        return VERSION;
    }
    public static String getCOMPANY() {
        return COMPANY;
    }
}
