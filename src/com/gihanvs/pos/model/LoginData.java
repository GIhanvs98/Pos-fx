package com.gihanvs.pos.model;

public class LoginData {
    private int statusCode;
    private String msg;
    private String email;
    private String displayName;
    private boolean status;

    public LoginData() {
    }

    public LoginData(int statusCode, String msg, String email, String displayName, boolean status) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.email = email;
        this.displayName = displayName;
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
