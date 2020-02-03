package com.example.tranquangthien;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TruyVanMonAn {

    SQLiteDatabase database;

    public TruyVanMonAn(Activity context){
        SQLiteHelper db = new SQLiteHelper(context);
        database = db.open();
    }

    public List<MonAn> LayDanhSachMonAnTheoLoai(int maloai){
        List<MonAn> monAnList = new ArrayList<MonAn>();
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_MONAN + " WHERE " + SQLiteHelper.TB_MONAN_MALOAI + " = '" + maloai + "' ";
        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            MonAn monAn = new MonAn();
            monAn.setHINHANH(cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_MONAN_HINHANH)));
            monAn.setTENMONAN(cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_MONAN_TENMONAN)));
            monAn.setGIATIEN(cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_MONAN_GIATIEN)));
            monAn.setMAMONAN(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_MONAN_MAMONAN)));
            monAn.setMALOAI(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_MONAN_MALOAI)));
            monAn.setTRANGTHAI(cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_MONAN_TRANGTHAI)));

            monAnList.add(monAn);
            cursor.moveToNext();
        }
        return monAnList;
    }

    public boolean capNhatLaiMonAn(int mamonan, String tenmonan, String giatien){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_MONAN_TENMONAN,tenmonan);
        values.put(SQLiteHelper.TB_MONAN_GIATIEN,giatien);

        long kiemtra = database.update(SQLiteHelper.TB_MONAN,values,SQLiteHelper.TB_MONAN_MAMONAN +" = '" + mamonan + "'",null);
        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }

//    public boolean xoaMonAnTheoMaMaMonAn(int mamonan){
//        long kiemtra = database.delete(SQLiteHelper.TB_MONAN, SQLiteHelper.TB_MONAN_MAMONAN + " = " + mamonan ,null);
//
//        if (kiemtra != 0){
//            return true;
//        }else{
//            return false;
//        }
//    }

    public boolean xoaMonAnTheoMaLoai(int maloai){
        long kiemtra = database.delete(SQLiteHelper.TB_MONAN, SQLiteHelper.TB_MONAN_MALOAI + " = " + maloai ,null);

        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }

    public void xoaTatCaCacMonAn(){
        database.delete(SQLiteHelper.TB_MONAN,null,null);
    }

    public boolean ThemMonAn(MonAn monAn){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_MONAN_TENMONAN,monAn.getTENMONAN());
        values.put(SQLiteHelper.TB_MONAN_GIATIEN,monAn.getGIATIEN());
        values.put(SQLiteHelper.TB_MONAN_MALOAI,monAn.getMALOAI());
        values.put(SQLiteHelper.TB_MONAN_HINHANH,monAn.getHINHANH());
        values.put(SQLiteHelper.TB_MONAN_TRANGTHAI,monAn.getTRANGTHAI());

        long kiemtra = database.insert(SQLiteHelper.TB_MONAN,null,values);
        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }




    //tạm
    public String layTenMonAnTheoMa (int maMonAn){
        String tenMonAn = null;
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_MONAN + " WHERE " + SQLiteHelper.TB_MONAN_MAMONAN + " = '" + maMonAn + "' ";
        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            tenMonAn = (cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_MONAN_TENMONAN)));

            cursor.moveToNext();
        }
        return tenMonAn;
    }

    public String layGiaMonAnTheoMa (int maMonAn){
        String giaMonAn = null;
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_MONAN + " WHERE " + SQLiteHelper.TB_MONAN_MAMONAN + " = '" + maMonAn + "' ";
        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            giaMonAn = (cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_MONAN_GIATIEN)));

            cursor.moveToNext();
        }
        return giaMonAn;
    }

    public boolean capNhatLaiTinhTrangMonAn(int mamonan, String trangthai){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_MONAN_TRANGTHAI,trangthai);

        long kiemtra = database.update(SQLiteHelper.TB_MONAN,values,SQLiteHelper.TB_MONAN_MAMONAN +" = '" + mamonan + "'",null);
        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }

}
