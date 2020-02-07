package com.example.tranquangthien.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tranquangthien.Adapter.HienThiBanAnAdapter;
import com.example.tranquangthien.Model.BanAn;
import com.example.tranquangthien.R;

import java.util.ArrayList;

public class Activity_HienThiBanAn extends AppCompatActivity {
    RecyclerView recyclerView;
    HienThiBanAnAdapter adapter;
    ArrayList<BanAn> mBanAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_ban_an);

        recyclerView = findViewById(R.id.bananlist);

        mBanAn = new ArrayList<BanAn>();
        for (int i = 1; i <= 20; i++) {
            mBanAn.add(new BanAn("Student Name"+i , "Chưa Đặt"));
        }

        adapter = new HienThiBanAnAdapter(mBanAn, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}