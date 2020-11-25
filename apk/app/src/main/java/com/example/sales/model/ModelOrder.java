package com.example.sales.model;

import com.google.gson.annotations.SerializedName;

public class ModelOrder {

    @SerializedName("iduser")
    String iduser;
    @SerializedName("idtoko")
    String idtoko;
    @SerializedName("stok")
    String stok;

    public ModelOrder(){}

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getIdtoko() {
        return idtoko;
    }

    public void setIdtoko(String idtoko) {
        this.idtoko = idtoko;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }
}
