package com.example.tranquangthien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_Chon_Ban extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__chon__ban);
    }

    public void openChonMon(View view) {

        Intent intent = new Intent(this, activity_Chon_Mon.class);
        startActivity(intent);

    }
}
