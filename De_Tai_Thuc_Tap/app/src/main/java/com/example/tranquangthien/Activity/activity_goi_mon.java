package com.example.tranquangthien.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tranquangthien.R;

public class activity_goi_mon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__chon__mon);
    }

    public void openThanhToan(View view) {

        Intent intent = new Intent(this, activity_Thanh_Toan_TaiKhoan.class);
        startActivity(intent);

    }
}