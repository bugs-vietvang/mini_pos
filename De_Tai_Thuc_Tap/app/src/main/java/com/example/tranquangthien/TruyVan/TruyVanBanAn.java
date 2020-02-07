package com.example.tranquangthien.TruyVan;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tranquangthien.Model.BanAn;

import java.util.ArrayList;

public class TruyVanBanAn {

    SQLiteDatabase database;

    public TruyVanBanAn(Activity context){
        SQLiteHelper db = new SQLiteHelper(context);
        database = db.open();
    }

    public boolean themBanAn(BanAn banAn){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_BANAN_TENBAN,banAn.getTENBAN());
        values.put(SQLiteHelper.TB_BANAN_TRANGTHAI,banAn.getTRANGTHAI());

        long kiemtra = database.insert(SQLiteHelper.TB_BANAN,null,values);
        if(kiemtra != 0 ){
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<BanAn> layTatCaBanAn(){
        ArrayList<BanAn> banAnList = new ArrayList<BanAn>();
        String cauTruyVan = "SELECT * FROM " +SQLiteHelper.TB_BANAN + " ORDER BY " +SQLiteHelper.TB_BANAN_MABAN + " ASC ";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            BanAn banAn = new BanAn();
            banAn.setMABAN(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_BANAN_MABAN)));
            banAn.setTENBAN(cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_BANAN_TENBAN)));
            banAn.setTRANGTHAI(cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_BANAN_TRANGTHAI)));

            banAnList.add(banAn);
            cursor.moveToNext();
        }
//        return banAnList;
//    }
    public void xoaTatCaBanAn(){
        database.delete(SQLiteHelper.TB_BANAN,null,null);
    }

    public boolean xoaBanAnTheoMa(int maban){
        long kiemtra = database.delete(SQLiteHelper.TB_BANAN, SQLiteHelper.TB_BANAN_MABAN + " = " + maban ,null);

        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean capNhatLaiTenBan(int maban, String tenban){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_BANAN_TENBAN,tenban);

        long kiemtra = database.update(SQLiteHelper.TB_BANAN,values,SQLiteHelper.TB_BANAN_MABAN +" = '" + maban + "'",null);
        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }

    public String layTinhTrangBanTheoMa(int maban){
        String tinhtrang = "";
        String cautruyvan = "SELECT * FROM " +SQLiteHelper.TB_BANAN + " WHERE " + SQLiteHelper.TB_BANAN_MABAN + " = '" + maban + "' ";
        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            tinhtrang = cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_BANAN_TRANGTHAI));

            cursor.moveToNext();
        }
        return tinhtrang;
    }
    public boolean capNhatLaiTinhTrangBan(int maban, String trangthai){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_BANAN_TRANGTHAI,trangthai);

        long kiemtra = database.update(SQLiteHelper.TB_BANAN,values,SQLiteHelper.TB_BANAN_MABAN +" = '" + maban + "'",null);
        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }

    public String layTenBanTheoMaBan(int maban){
        String tenban = null;
        String cautruyvan = "SELECT * FROM " +SQLiteHelper.TB_BANAN + " WHERE " +SQLiteHelper.TB_BANAN_MABAN + " = '" + maban + "' ";
        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            tenban = cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_BANAN_TENBAN));

            cursor.moveToNext();
        }
        return tenban;
    }


}
