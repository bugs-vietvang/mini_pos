package com.example.tranquangthien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_Chi_Tiet_Mon_An extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__chi__tiet__mon__an);
    }

    public void openThanhToan(View view) {

        Intent intent = new Intent(this, activity_Thanh_Toan_TaiKhoan.class);
        startActivity(intent);
    }
}
