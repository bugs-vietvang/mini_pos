package com.example.tranquangthien.Model;

public class GoiMon {

    int MAGOIMON,MABAN,MANHANVIEN;
    String TRANGTHAI,NGAYGOI, THOIGIANVAO;

    public GoiMon() {
    }

    public GoiMon(int MAGOIMON, int MABAN, int MANHANVIEN, String TRANGTHAI, String NGAYGOI, String THOIGIANVAO) {
        this.MAGOIMON = MAGOIMON;
        this.MABAN = MABAN;
        this.MANHANVIEN = MANHANVIEN;
        this.TRANGTHAI = TRANGTHAI;
        this.NGAYGOI = NGAYGOI;
        this.THOIGIANVAO = THOIGIANVAO;
    }

    public String getTHOIGIANVAO() {
        return THOIGIANVAO;
    }

    public void setTHOIGIANVAO(String THOIGIANVAO) {
        this.THOIGIANVAO = THOIGIANVAO;
    }

    public int getMAGOIMON() {
        return MAGOIMON;
    }

    public void setMAGOIMON(int MAGOIMON) {
        this.MAGOIMON = MAGOIMON;
    }

    public int getMABAN() {
        return MABAN;
    }

    public void setMABAN(int MAMONAN) {
        this.MABAN = MAMONAN;
    }

    public int getMANHANVIEN() {
        return MANHANVIEN;
    }

    public void setMANHANVIEN(int MANHANVIEN) {
        this.MANHANVIEN = MANHANVIEN;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public String getNGAYGOI() {
        return NGAYGOI;
    }

    public void setNGAYGOI(String NGAYGOI) {
        this.NGAYGOI = NGAYGOI;
    }

}
