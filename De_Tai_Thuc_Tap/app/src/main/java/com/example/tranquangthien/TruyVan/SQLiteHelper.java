package com.example.tranquangthien.TruyVan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static String TB_NHANVIEN = "TB_NHANVIEN";
    public static String TB_NHANVIEN_MANV = "MANHANVIEN";
    public static String TB_NHANVIEN_TENDANGNHAP = "TENDANGNHAP";
    public static String TB_NHANVIEN_MATKHAU = "MATKHAU";
    public static String TB_NHANVIEN_TENNHANVIEN = "TENNHANVIEN";

    public static String TB_LOAIMONAN = "TB_LOAIMONAN";
    public static String TB_LOAIMONAN_MALOAI = "MALOAI";
    public static String TB_LOAIMONAN_TENLOAI = "TENLOAI";

    public static String TB_MONAN = "TB_MONAN";
    public static String TB_MONAN_MAMONAN = "MAMONAN";
    public static String TB_MONAN_TENMONAN = "TENMONAN";
    public static String TB_MONAN_GIATIEN = "GIATIEN";
    public static String TB_MONAN_MALOAI = "MALOAI";
    public static String TB_MONAN_TRANGTHAI = "TRANGTHAI";

    public static String TB_BANAN = "TB_BANAN";
    public static String TB_BANAN_MABAN = "MABAN";
    public static String TB_BANAN_TENBAN = "TENBAN";
    public static String TB_BANAN_TRANGTHAI = "TRANGTHAI";

    public static String TB_GOIMON = "TB_GOIMON";
    public static String TB_GOIMON_MAGOIMON = "MAGOIMON";
    public static String TB_GOIMON_MANV= "MANV";
    public static String TB_GOIMON_NGAYGOI = "NGAYGOI";
    public static String TB_GOIMON_TRANGTHAI = "TRANGTHAI";
    public static String TB_GOIMON_MABAN = "MABAN";
    public static String TB_GOIMON_THOIGIANVAO = "THOIGIANVAO";

    public static String TB_CHITIETGOIMON = "TB_CHITIETGOIMON";
    public static String TB_CHITIETGOIMON_ID = "ID";
    public static String TB_CHITIETGOIMON_MAGOIMON = "MAGOIMON";
    public static String TB_CHITIETGOIMON_MAMONAN = "MAMONAN";
    public static String TB_CHITIETGOIMON_SOLUONG = "SOLUONG";
    public static String TB_CHITIETGOIMON_MANHANVIEN = "MANHANVIEN";
    public static String TB_CHITIETGOIMON_MALOAI = "MALOAI";
    public static String TB_CHITIETGOIMON_TENMONAN = "TENMONAN";
    public static String TB_CHITIETGOIMON_GIATIEN = "GIATIEN";


    public static String TB_LUUTAM = "TB_LUU_TAM";
    public static String TB_LUUTAM_MALUUTAM = "MALUUTAM";
    public static String TB_LUUTAM_MAGOIMON = "MAGOIMON";
    public static String TB_LUUTAM_MAMONAN = "MAMONAN";
    public static String TB_LUUTAM_SOLUONG = "SOLUONG";
    public static String TB_LUUTAM_MANHANVIEN = "MANHANVIEN";
    public static String TB_LUUTAM_MALOAI = "MALOAI";
    public static String TB_LUUTAM_LUUY = "LUUY";

    public static String TB_KIEMTRADAXUATBILL = "TB_KIEMTRADAXUATBILL";
    public static String TB_KIEMTRADAXUATBILL_KIEMTRA = "KIEMTRA";
    public static String TB_KIEMTRADAXUATBILL_MABAN = "MABAN";
    public SQLiteHelper(@Nullable Context context) {
        super(context, "MayPosmini", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TB_BANAN = "CREATE TABLE TB_BANAN (MABAN INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , TENBAN TEXT, TRANGTHAI TEXT)";

        String TB_CHITIETGOIMON = "CREATE TABLE TB_CHITIETGOIMON (ID INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL," +
                "MAGOIMON INTEGER  NOT NULL ,MAMONAN INTEGER NOT NULL ,SOLUONG INTEGER,MANHANVIEN INTEGER," +
                "MALOAI INTEGER,TENMONAN TEXT,GIATIEN TEXT)";

        String TB_GOIMON = "CREATE TABLE TB_GOIMON (MAGOIMON INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL ," +
                " MANV INTEGER, NGAYGOI TEXT, TRANGTHAI TEXT, MABAN INTEGER, THOIGIANVAO TEXT)";

        String TB_KIEMTRADAXUATBILL = "CREATE TABLE TB_KIEMTRADAXUATBILL (MAKIEMTRA INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL ," +
                " KIEMTRA BOOL, MABAN INTEGER)";

        String TB_LOAIMONAN = "CREATE TABLE TB_LOAIMONAN (MALOAI INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , TENLOAI TEXT)";

        String TB_LUU_TAM = "CREATE TABLE TB_LUU_TAM (MALUUTAM INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , MAGOIMON INTEGER, " +
                "MAMONAN INTEGER, SOLUONG INTEGER, MANHANVIEN INTEGER, MALOAI INTEGER, LUUY TEXT)";

        String TB_MONAN = "CREATE TABLE TB_MONAN (MAMONAN INTEGER PRIMARY KEY  NOT NULL ,TENMONAN TEXT,GIATIEN TEXT," +
                "MALOAI INTEGER,TRANGTHAI TEXT)";

        String TB_NHANVIEN = "CREATE TABLE TB_NHANVIEN (MANHANVIEN INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , " +
                "TENNHANVIEN TEXT, TENDANGNHAP TEXT)";

        db.execSQL(TB_BANAN);
        db.execSQL(TB_CHITIETGOIMON);
        db.execSQL(TB_GOIMON);
        db.execSQL(TB_KIEMTRADAXUATBILL);
        db.execSQL(TB_LOAIMONAN);
        db.execSQL(TB_LUU_TAM);
        db.execSQL(TB_MONAN);
        db.execSQL(TB_NHANVIEN);

    }
    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
