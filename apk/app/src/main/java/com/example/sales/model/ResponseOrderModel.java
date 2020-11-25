package com.example.sales.model;

import java.util.List;

public class ResponseOrderModel {
    String kode, pesan;
    List<ModelOrder> result;

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

    public List<ModelOrder> getResult() {
        return result;
    }

    public void setResult(List<ModelOrder> result) {
        this.result = result;
    }
}
