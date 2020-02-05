package com.example.tranquangthien.TruyVan;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TruyVanNhanVien {

    SQLiteDatabase database;

    public TruyVanNhanVien(Activity context){
        SQLiteHelper db = new SQLiteHelper(context);
        database = db.open();
    }
    public boolean kiemTraNhanVien(){
        String cauTruyVan = "SELECT * FROM " + SQLiteHelper.TB_NHANVIEN;
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        if(cursor.getCount()!=0){
            return true;
        }else{
            return false;
        }
    }

    public int kiemTraDangNhap(String tendangnhap, String matkhau){
        String cauTruyVan = "SELECT * FROM " +SQLiteHelper.TB_NHANVIEN + " WHERE " + SQLiteHelper.TB_NHANVIEN_TENDANGNHAP + " = '" + tendangnhap
                + "' AND " +SQLiteHelper.TB_NHANVIEN_MATKHAU + " = '" + matkhau +"'";

        int manhanvien = -1;
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            manhanvien = cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_NHANVIEN_MANV));
            cursor.moveToNext();
        }
        return manhanvien;
    }
}
