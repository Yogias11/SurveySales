package com.example.sales.model;

import java.util.List;

public class ResponseModel {
    String kode, pesan;
    List<TokoModel> result;

    public List<TokoModel> getResult() {
        return result;
    }

    public void setResult(List<TokoModel> result) {
        this.result = result;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
