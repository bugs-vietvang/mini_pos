package com.example.tranquangthien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_Thanh_Toan_TaiKhoan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__thanh__toan__tai_khoan);
    }

    public void openThanhToanTienMat(View view) {

        Intent intent = new Intent(this, activity_Thanh_Toan_Tien_Mat.class);
        startActivity(intent);
    }

    public void openTheTinDung(View view) {



    }
}
