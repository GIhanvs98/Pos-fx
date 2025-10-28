package com.gihanvs.pos.dto.response;

public class ResponseUserDto {
    private String displayName;
    private String contactNumber;

    public ResponseUserDto() {
    }

    public ResponseUserDto(String displayName, String contactNumber) {
        this.displayName = displayName;
        this.contactNumber = contactNumber;
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
}
