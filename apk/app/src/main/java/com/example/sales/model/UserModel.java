package com.example.sales.model;

import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("iduser")
    String iduser;
    @SerializedName("fullname")
    String fullname;
    @SerializedName("username")
    String username;

    public UserModel(){}

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
