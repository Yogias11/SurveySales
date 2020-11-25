package com.example.sales.model;

import java.util.List;

public class ResponsePromoModel {
    String kode, pesan;
    List<PromoModel> result;

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

    public List<PromoModel> getResult() {
        return result;
    }

    public void setResult(List<PromoModel> result) {
        this.result = result;
    }
}
