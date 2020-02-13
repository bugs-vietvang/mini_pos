package com.example.tranquangthien.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class BanAn implements Serializable {

    private int MABAN;
    private String TENBAN;
    private String TRANGTHAI;

    public BanAn() {

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

    public BanAn(String TENBAN, String TRANGTHAI) {
        this.TENBAN = TENBAN;
        this.TRANGTHAI = TRANGTHAI;
    }

}
