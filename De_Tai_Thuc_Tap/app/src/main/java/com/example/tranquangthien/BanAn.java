package com.example.tranquangthien;

public class BanAn {

    int MABAN;
    String TENBAN, TRANGTHAI;
    boolean DUOCCHON;

    public BanAn() {
    }

    public BanAn(int MABAN, String TENBAN, String TRANGTHAI, boolean DUOCCHON) {
        this.MABAN = MABAN;
        this.TENBAN = TENBAN;
        this.TRANGTHAI = TRANGTHAI;
        this.DUOCCHON = DUOCCHON;
    }

    public boolean isDUOCCHON() {
        return DUOCCHON;
    }

    public void setDUOCCHON(boolean DUOCCHON) {
        this.DUOCCHON = DUOCCHON;
    }

    public int getMABAN() {
        return MABAN;
    }

    public void setMABAN(int MABAN) {
        this.MABAN = MABAN;
    }

    public String getTENBAN() {
        return TENBAN;
    }

    public void setTENBAN(String TENBAN) {
        this.TENBAN = TENBAN;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

}
