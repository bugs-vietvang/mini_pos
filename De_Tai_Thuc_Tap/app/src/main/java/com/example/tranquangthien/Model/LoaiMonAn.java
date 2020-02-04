package com.example.tranquangthien.Model;

public class LoaiMonAn {

    int MALOAI;
    String TENLOAI,HINHANH;

    public LoaiMonAn() {
    }

    public LoaiMonAn(int MALOAI, String TENLOAI, String HINHANH) {
        this.MALOAI = MALOAI;
        this.TENLOAI = TENLOAI;
        this.HINHANH = HINHANH;
    }

    public String getHINHANH() {
        return HINHANH;
    }

    public void setHINHANH(String HINHANH) {
        this.HINHANH = HINHANH;
    }

    public int getMALOAI() {
        return MALOAI;
    }

    public void setMALOAI(int MALOAI) {
        this.MALOAI = MALOAI;
    }

    public String getTENLOAI() {
        return TENLOAI;
    }

    public void setTENLOAI(String TENLOAI) {
        this.TENLOAI = TENLOAI;
    }

}
