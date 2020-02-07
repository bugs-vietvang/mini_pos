package com.example.tranquangthien.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tranquangthien.Adapter.DanhSachMonAnAdapter;
import com.example.tranquangthien.Adapter.HienThiBanAnAdapter;
import com.example.tranquangthien.Model.BanAn;
import com.example.tranquangthien.Model.MonAn;
import com.example.tranquangthien.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

public class activity_Chon_Mon extends AppCompatActivity {

    RecyclerView recyclerView;
    DanhSachMonAnAdapter adapter;
    ArrayList<MonAn> mMonAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__chon__mon);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        recyclerView = findViewById(R.id.rvGoiMon);

        mMonAn = new ArrayList<MonAn>();
        for (int i = 1; i <= 20; i++) {
            mMonAn.add(new MonAn("Món "+i , "10.000"));
        }

        adapter = new DanhSachMonAnAdapter(mMonAn, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        int spanCount = 3;
//        int orientation = GridLayoutManager.VERTICAL;
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
//        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(gridLayoutManager);
    }

    public void Back(View view) {

        Intent intent = new Intent(this, Activity_HienThiBanAn.class);
        startActivity(intent);

    }
}
