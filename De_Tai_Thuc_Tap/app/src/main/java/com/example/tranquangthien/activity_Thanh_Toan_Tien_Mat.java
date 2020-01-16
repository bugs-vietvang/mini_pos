package com.example.tranquangthien;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity_Thanh_Toan_Tien_Mat extends AppCompatActivity {
    private EditText giamgia, tiennhan, tip;
    private TextView tongtien, thanhtien, tientralai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__thanh__toan__tien__mat);
        AnhXa();
    }

    private void AnhXa() {

        tongtien = (TextView)findViewById(R.id.txtTongTien2);
        thanhtien = (TextView)findViewById(R.id.txtThanhTien2);
        tientralai = (TextView)findViewById(R.id.txtTralai2);
        giamgia = (EditText)findViewById(R.id.edt_giamgia2);
        tiennhan = (EditText)findViewById(R.id.edt_TienNhan1);
        tip = (EditText)findViewById(R.id.edt_tientip1);

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

    public void TinhTien(View view) {

        TinhThanhTien();
    }

    public void TienTraLai(View view) {

        TienTraLai();

    }

    public void opentheTinDung(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setTitle("Chọn Thẻ Thanh Toán");
        dialog.setContentView(R.layout.dialog_thanh_toan);
        dialog.setCancelable(true);
        dialog.show();
    }
}
