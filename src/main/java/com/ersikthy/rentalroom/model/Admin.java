package com.ersikthy.rentalroom.model;

import java.util.UUID;

public class Admin {
    private String id;
    private String adminName;
    private  String password;


    public  Admin () {};

    public Admin(String adminName, String password) {
        this.id = UUID.randomUUID().toString();
        this.adminName = adminName;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {return id + "." + adminName + " " + password;}
}
