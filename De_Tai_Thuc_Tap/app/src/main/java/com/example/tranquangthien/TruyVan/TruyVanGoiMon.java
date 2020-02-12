package com.example.tranquangthien.TruyVan;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tranquangthien.Model.GoiMon;
import com.example.tranquangthien.Model.Order;
import com.example.tranquangthien.Model.ThanhToan;

import java.util.ArrayList;
import java.util.List;

public class TruyVanGoiMon {

    SQLiteDatabase database;

    public TruyVanGoiMon(Activity context){
        SQLiteHelper db = new SQLiteHelper(context);
        database = db.open();
    }

    public long themGoiMon(GoiMon goiMon){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_GOIMON_MABAN,goiMon.getMABAN());
        values.put(SQLiteHelper.TB_GOIMON_MANV,goiMon.getMANHANVIEN());
        values.put(SQLiteHelper.TB_GOIMON_NGAYGOI,goiMon.getNGAYGOI());
        values.put(SQLiteHelper.TB_GOIMON_TRANGTHAI,goiMon.getTRANGTHAI());
        values.put(SQLiteHelper.TB_GOIMON_THOIGIANVAO, goiMon.getTHOIGIANVAO());

        long magoimon = database.insert(SQLiteHelper.TB_GOIMON,null,values);
        return magoimon;
    }

    public long themGoiMonFromServer(GoiMon goiMon){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_GOIMON_MAGOIMON,goiMon.getMAGOIMON());
        values.put(SQLiteHelper.TB_GOIMON_MABAN,goiMon.getMABAN());
        values.put(SQLiteHelper.TB_GOIMON_MANV,goiMon.getMANHANVIEN());
        values.put(SQLiteHelper.TB_GOIMON_NGAYGOI,goiMon.getNGAYGOI());
        values.put(SQLiteHelper.TB_GOIMON_TRANGTHAI,goiMon.getTRANGTHAI());
        values.put(SQLiteHelper.TB_GOIMON_THOIGIANVAO, goiMon.getTHOIGIANVAO());

        long magoimon = database.replace(SQLiteHelper.TB_GOIMON,null,values);
        return magoimon;
    }

    public int layMaGoiMonTheoMaBan(int maban, String tinhtrang){
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_GOIMON + " WHERE " + SQLiteHelper.TB_GOIMON_MABAN + " = '" + maban + "' AND " +
                SQLiteHelper.TB_GOIMON_TRANGTHAI + " = '" + tinhtrang + "' ";

        int magoimon = 0;
        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            magoimon = cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_GOIMON_MAGOIMON));

            cursor.moveToNext();
        }
        return magoimon;
    }

    public boolean kiemTraMonAnDaTonTai(int magoimon, int mamonan){
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_CHITIETGOIMON + " WHERE " + SQLiteHelper.TB_CHITIETGOIMON_MAMONAN + " = '" +mamonan+ "' AND "
                + SQLiteHelper.TB_CHITIETGOIMON_MAGOIMON + " = '" +magoimon+ "'";

        Cursor cursor = database.rawQuery(cautruyvan,null);
        if (cursor.getCount() != 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean capNhatSoLuong(Order order){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_CHITIETGOIMON_SOLUONG,order.getSoLuong());

        long kiemtra = database.update(SQLiteHelper.TB_CHITIETGOIMON,values,SQLiteHelper.TB_CHITIETGOIMON_MAMONAN + " = " + order.getMaMonAn()
                + " AND " + SQLiteHelper.TB_CHITIETGOIMON_MAGOIMON + " = " +order.getMaOrder(),null);

        if (kiemtra !=0 ){
            return true;
        }else{
            return false;
        }
    }

    public boolean themChiTietGoiMon(Order order){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_CHITIETGOIMON_SOLUONG,order.getSoLuong());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_MAGOIMON,order.getMaOrder());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_MAMONAN,order.getMaMonAn());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_MANHANVIEN, order.getMaNhanVien());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_MALOAI, order.getMaLoai());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_TENMONAN,order.getTenMonAn());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_GIATIEN,order.getGiaTien());

        long kiemtra = database.insert(SQLiteHelper.TB_CHITIETGOIMON,null,values);
        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }
    public boolean themChiTietGoiMonFromServer(Order order){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_CHITIETGOIMON_ID, order.getId());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_SOLUONG,order.getSoLuong());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_MAGOIMON,order.getMaOrder());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_MAMONAN,order.getMaMonAn());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_MANHANVIEN, order.getMaNhanVien());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_MALOAI, order.getMaLoai());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_TENMONAN,order.getTenMonAn());
        values.put(SQLiteHelper.TB_CHITIETGOIMON_GIATIEN,order.getGiaTien());

        long kiemtra = database.replace(SQLiteHelper.TB_CHITIETGOIMON,null,values);
        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }
    public int layMaNhanVienTuMaGoiMon(int magoimon){
        int maNhanVien = 0;
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_GOIMON + " WHERE " + SQLiteHelper.TB_GOIMON_MAGOIMON + " = " +magoimon;

        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            maNhanVien = cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_GOIMON_MANV));
            cursor.moveToNext();
        }
        return maNhanVien;
    }

    public int laySoLuongMonAnTheoMaGoiMon(int magoimon, int mamonan){
        int soluong = 0;
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_CHITIETGOIMON + " WHERE " + SQLiteHelper.TB_CHITIETGOIMON_MAMONAN + " = " +mamonan+ " AND "
                + SQLiteHelper.TB_CHITIETGOIMON_MAGOIMON + " = " +magoimon;

        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            soluong = cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_CHITIETGOIMON_SOLUONG));
            cursor.moveToNext();
        }
        return soluong;
    }

    public boolean capNhatSoLuongTheoMaMonAn(int soLuong, int maMonAn, int magoimon){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_CHITIETGOIMON_SOLUONG,soLuong);

        long kiemtra = database.update(SQLiteHelper.TB_CHITIETGOIMON,values,SQLiteHelper.TB_CHITIETGOIMON_MAMONAN
                + " = " + maMonAn+ " AND " + SQLiteHelper.TB_CHITIETGOIMON_MAGOIMON + " = " +magoimon, null);

        if (kiemtra !=0 ){
            return true;
        }else{
            return false;
        }
    }

    public void xoaMonAnKhiSoLuongBangKhong(int mamonan, int magoimon){
        database.delete(SQLiteHelper.TB_CHITIETGOIMON, SQLiteHelper.TB_CHITIETGOIMON_MAMONAN + " = "+mamonan+" AND "
                +SQLiteHelper.TB_CHITIETGOIMON_MAGOIMON+" = "+magoimon,null);
    }

    //TB_LUUTAM
    public boolean themLuuTam (Order order){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_LUUTAM_MAGOIMON,order.getMaOrder());
        values.put(SQLiteHelper.TB_LUUTAM_MALOAI,order.getMaLoai());
        values.put(SQLiteHelper.TB_LUUTAM_MANHANVIEN,order.getMaNhanVien());
        values.put(SQLiteHelper.TB_LUUTAM_MAMONAN,order.getMaMonAn());
        values.put(SQLiteHelper.TB_LUUTAM_SOLUONG,order.getSoLuong());
        values.put(SQLiteHelper.TB_LUUTAM_LUUY,order.getLuuYChoBep());

        long kiemtra = database.insert(SQLiteHelper.TB_LUUTAM,null,values);
        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }

    public int laySoLuongMonAnTheoMaGoiMonTBLUUTAM(int magoimon, int mamonan){
        int soluong = 0;
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_LUUTAM + " WHERE " + SQLiteHelper.TB_LUUTAM_MAMONAN + " = " +mamonan+ " AND "
                + SQLiteHelper.TB_LUUTAM_MAGOIMON + " = " +magoimon;

        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            soluong = cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_LUUTAM_SOLUONG));
            cursor.moveToNext();
        }
        return soluong;
    }

    public boolean kiemTraMonAnDaTonTaiTBLUUTAM(int magoimon, int mamonan){
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_LUUTAM + " WHERE " + SQLiteHelper.TB_LUUTAM_MAMONAN + " = '" +mamonan+ "' AND "
                + SQLiteHelper.TB_LUUTAM_MAGOIMON + " = '" +magoimon+ "'";

        Cursor cursor = database.rawQuery(cautruyvan,null);
        if (cursor.getCount() != 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean capNhatSoLuongTBLUUTAM(Order order){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_LUUTAM_SOLUONG,order.getSoLuong());

        long kiemtra = database.update(SQLiteHelper.TB_LUUTAM,values,SQLiteHelper.TB_LUUTAM_MAMONAN + " = " + order.getMaMonAn()
                + " AND " + SQLiteHelper.TB_LUUTAM_MAGOIMON + " = " +order.getMaOrder(),null);

        if (kiemtra !=0 ){
            return true;
        }else{
            return false;
        }
    }

    public List<Order> layDuLieuTBLUUTAM(){
        List<Order> orderList = new ArrayList<Order>();
        String cautruyvan = "SELECT * FROM " +SQLiteHelper.TB_LUUTAM;

        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Order order = new Order();
            order.setMaLoai(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_LUUTAM_MALOAI)));
            order.setMaOrder(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_LUUTAM_MAGOIMON)));
            order.setMaMonAn(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_LUUTAM_MAMONAN)));
            order.setSoLuong(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_LUUTAM_SOLUONG)));
            order.setLuuYChoBep(cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_LUUTAM_LUUY)));


            orderList.add(order);
            cursor.moveToNext();
        }
        return orderList;
    }

    public boolean xoaMonAnTBLUUTAM(int maMonAn){
        long kiemtra = database.delete(SQLiteHelper.TB_LUUTAM, SQLiteHelper.TB_LUUTAM_MAMONAN + " = "+maMonAn,null);
        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }

    public void xoaTatCaTBLUUTAM(){
        database.delete(SQLiteHelper.TB_LUUTAM,null,null);
    }

    //
    public List<Order> layDanhSachCacMonDaGoiTheoMaGoiMon (int maGoiMon){
        List<Order> orderList = new ArrayList<>();

        String cautruyvan = "SELECT * FROM " +SQLiteHelper.TB_CHITIETGOIMON + " WHERE "+SQLiteHelper.TB_CHITIETGOIMON_MAGOIMON+" = '"+maGoiMon+"'";

        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Order order = new Order();
            order.setMaOrder(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_CHITIETGOIMON_MAGOIMON)));
            order.setMaLoai(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_CHITIETGOIMON_MALOAI)));
            order.setMaMonAn(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_CHITIETGOIMON_MAMONAN)));
            order.setMaNhanVien(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_CHITIETGOIMON_MANHANVIEN)));
            order.setSoLuong(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_CHITIETGOIMON_SOLUONG)));
            order.setGiaTien(cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_CHITIETGOIMON_GIATIEN)));
            order.setTenMonAn(cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_CHITIETGOIMON_TENMONAN)));

            orderList.add(order);
            cursor.moveToNext();
        }

        return orderList;
    }

    public String layThoiGianVaoTheoMaBanVaMaGoiMon(int maban, int magoimon){
        String thoigianvao = "";
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_GOIMON + " WHERE " + SQLiteHelper.TB_GOIMON_MABAN + " = '" + maban + "' AND " +
                SQLiteHelper.TB_GOIMON_MAGOIMON + " = '" + magoimon + "' ";

        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            thoigianvao = cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_GOIMON_THOIGIANVAO));

            cursor.moveToNext();
        }
        return thoigianvao;
    }

    public List<ThanhToan> layDanhSachCacMonDaGoiTheoMaGoiMonThanhToan (int maGoiMon){
        List<ThanhToan> thanhToanList = new ArrayList<>();

        String cautruyvan = "SELECT * FROM " +SQLiteHelper.TB_CHITIETGOIMON + " WHERE "+SQLiteHelper.TB_CHITIETGOIMON_MAGOIMON+" = '"+maGoiMon+"'";

        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ThanhToan thanhToan = new ThanhToan();
            thanhToan.setSoLuong(cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_CHITIETGOIMON_SOLUONG)));
            thanhToan.setGiaTien(cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_CHITIETGOIMON_GIATIEN)));
            thanhToan.setTenMonAn(cursor.getString(cursor.getColumnIndex(SQLiteHelper.TB_CHITIETGOIMON_TENMONAN)));


            thanhToanList.add(thanhToan);
            cursor.moveToNext();
        }
        return thanhToanList;
    }

    public boolean capNhatTrangThaiGoiMonTheoMaBan(int maban,String tinhtrang, int magoimon){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.TB_GOIMON_TRANGTHAI,tinhtrang);

        long kiemtra = database.update(SQLiteHelper.TB_GOIMON,values,SQLiteHelper.TB_GOIMON_MABAN + " = '" + maban + "' AND "
                +SQLiteHelper.TB_GOIMON_MAGOIMON+" = "+magoimon,null);
        if (kiemtra != 0){
            return true;
        }else{
            return false;
        }
    }

    public int layMaBanTuMaGoiMon(int magoimon){
        int maban = 0;
        String cautruyvan = "SELECT * FROM " + SQLiteHelper.TB_GOIMON + " WHERE "+SQLiteHelper.TB_GOIMON_MAGOIMON + " = '" + magoimon + "' ";

        Cursor cursor = database.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            maban = cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TB_GOIMON_MABAN));

            cursor.moveToNext();
        }
        return maban;
    }
}

