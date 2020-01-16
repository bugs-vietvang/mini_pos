package com.example.tranquangthien;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity_Thanh_Toan_TaiKhoan extends AppCompatActivity {

    private EditText giamgia, tiennhan, tip;
    private TextView tongtien, thanhtien, tientralai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__thanh__toan__tai_khoan);

        AnhXa();
    }

    private void AnhXa() {

        tongtien = (TextView)findViewById(R.id.txtTongTien1);
        thanhtien = (TextView)findViewById(R.id.txtThanhTien1);
        tientralai = (TextView)findViewById(R.id.txtTralai1);
        giamgia = (EditText)findViewById(R.id.edt_giamgia);
        tiennhan = (EditText)findViewById(R.id.edt_TienNhan);
        tip = (EditText)findViewById(R.id.edt_tientip);

    }

    public void openThanhToanTienMat(View view) {

        Intent intent = new Intent(this, activity_Thanh_Toan_Tien_Mat.class);
        startActivity(intent);
    }

    public void openTheTinDung(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setTitle("Chọn Thẻ Thanh Toán");
        dialog.setContentView(R.layout.dialog_thanh_toan);
        dialog.setCancelable(true);
        dialog.show();
    }
    public void TinhThanhTien()
    {
        float TongTien = Float.valueOf(tongtien.getText().toString());
        float GiamGia = Float.valueOf(giamgia.getText().toString());
        float Cong = TongTien + TongTien*(GiamGia/100);
        String tong = String.valueOf(Cong + " K");
        thanhtien.setText(tong);

    }
    public void TienTraLai()
    {
        float TongTien = Float.valueOf(tongtien.getText().toString());
        float GiamGia = Float.valueOf(giamgia.getText().toString());
        float TienNhan = Float.valueOf(tiennhan.getText().toString());
        float Tip = Float.valueOf(tip.getText().toString());
        float Cong = TongTien + TongTien*(GiamGia/100) + TienNhan + Tip;
        String tra = String.valueOf(Cong + " K");
        tientralai.setText(tra);

    }

    public void tinhthanhtien(View view) {

        TinhThanhTien();
    }

    public void TienTraLai(View view) {

        TienTraLai();

    }


}
