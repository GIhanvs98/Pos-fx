package com.gihanvs.pos.dto.response;

public class ResponseUserDto {
    private String displayName;
    private String contactNumber;
    private int statusCode;
    private String msg;
    private String email;
    private boolean status;

    public ResponseUserDto(String displayName, String contactNumber, int statusCode, String msg, String email, boolean status) {
        this.displayName = displayName;
        this.contactNumber = contactNumber;
        this.statusCode = statusCode;
        this.msg = msg;
        this.email = email;
        this.status = status;
    }

    public ResponseUserDto() {
    }



    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
