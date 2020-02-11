package com.example.tranquangthien.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tranquangthien.R;

public class activity_ThongTin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__thong_tin);
    }

    public void opengoimon(View view) {

        Intent intent = new Intent(this, activity_Chon_Mon.class);
        startActivity(intent);

    }

    public void ThanhToan(View view) {

        Intent intent = new Intent(this, activity_Thanh_Toan_TaiKhoan.class);
        startActivity(intent);

    }

    public void openchitietmonan(View view) {
        Intent intent = new Intent(this, activity_Chi_Tiet_Mon_An.class);
        startActivity(intent);


    }
}
