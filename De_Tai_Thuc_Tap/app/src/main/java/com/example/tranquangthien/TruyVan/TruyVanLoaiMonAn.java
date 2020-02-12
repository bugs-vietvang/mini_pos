package com.example.tranquangthien.TruyVan;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tranquangthien.Model.LoaiMonAn;

import java.util.ArrayList;
import java.util.List;

public class TruyVanLoaiMonAn {

    SQLiteDatabase database;

    public TruyVanLoaiMonAn(Activity context){
        SQLiteHelper db = new SQLiteHelper(context);
        database = db.open();
    }

    public String LayHinhLoaiMonAn(int maloai){
        String hinhanh = "";
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_MONAN + " WHERE " + SQLiteHelper.TB_MONAN_MALOAI + " = '" + maloai + "' " + " != '' ORDER BY " + SQLiteHelper.TB_MONAN_MAMONAN + " LIMIT 1";
        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
//            hinhanh = cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_MONAN_HINHANH));
            cursor.moveToNext();
        }
        return hinhanh;
    }

    public List<LoaiMonAn> LayDanhSachLoaiMonAn(){
        List<LoaiMonAn> loaiMonAnList = new ArrayList<LoaiMonAn>();
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_LOAIMONAN;
        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LoaiMonAn loaiMonAn = new LoaiMonAn();
            loaiMonAn.setMALOAI(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_LOAIMONAN_MALOAI)));
            loaiMonAn.setTENLOAI(cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_LOAIMONAN_TENLOAI)));

            loaiMonAnList.add(loaiMonAn);

            cursor.moveToNext();
        }
        return loaiMonAnList;
    }

    public boolean xoaLoaiMonAnTheoMa(int maloai){
        long kiemtra = database.delete(SQLiteHelper.TB_LOAIMONAN, SQLiteHelper.TB_LOAIMONAN_MALOAI + " = " + maloai ,null);

        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean themLoaiMonAn (String tenloai){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_LOAIMONAN_TENLOAI,tenloai);

        long kiemtra = database.insert(SQLiteHelper.TB_LOAIMONAN,null,values);
        if(kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean themLoaiMonAnFromServer (LoaiMonAn loaiMonAn){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_LOAIMONAN_MALOAI, loaiMonAn.getMALOAI());
        values.put(SQLiteHelper.TB_LOAIMONAN_TENLOAI,loaiMonAn.getTENLOAI());

        long kiemtra = database.replace(SQLiteHelper.TB_LOAIMONAN,null,values);
        if(kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }

}
