package com.example.tranquangthien.Model;

import java.io.Serializable;

public class MonAn implements Serializable {

    int MAMONAN,MALOAI;
    String TENMONAN,GIATIEN,TRANGTHAI,HINHANH;

    public MonAn() {
    }

    public MonAn(int MAMONAN, int MALOAI, String TENMONAN, String GIATIEN, String TRANGTHAI, String HINHANH) {
        this.MAMONAN = MAMONAN;
        this.MALOAI = MALOAI;
        this.TENMONAN = TENMONAN;
        this.GIATIEN = GIATIEN;
        this.TRANGTHAI = TRANGTHAI;
        this.HINHANH = HINHANH;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public String getHINHANH() {
        return HINHANH;
    }

    public void setHINHANH(String HINHANH) {
        this.HINHANH = HINHANH;
    }

    public int getMAMONAN() {
        return MAMONAN;
    }

    public void setMAMONAN(int MAMONAN) {
        this.MAMONAN = MAMONAN;
    }

    public int getMALOAI() {
        return MALOAI;
    }

    public void setMALOAI(int MALOAI) {
        this.MALOAI = MALOAI;
    }

    public String getTENMONAN() {
        return TENMONAN;
    }

    public void setTENMONAN(String TENMONAN) {
        this.TENMONAN = TENMONAN;
    }

    public String getGIATIEN() {
        return GIATIEN;
    }

    public void setGIATIEN(String GIATIEN) {
        this.GIATIEN = GIATIEN;
    }

}
