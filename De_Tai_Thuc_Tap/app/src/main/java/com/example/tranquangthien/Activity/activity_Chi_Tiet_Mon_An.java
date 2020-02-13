package com.example.tranquangthien.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.tranquangthien.Adapter.DanhSachMonAnAdapter;
import com.example.tranquangthien.Model.MonAn;
import com.example.tranquangthien.R;

import java.util.ArrayList;

public class activity_Chi_Tiet_Mon_An extends AppCompatActivity {
    RecyclerView recyclerView;
    DanhSachMonAnAdapter adapter;
    ArrayList<MonAn> mMonAn;
    boolean isupdate;
    int idproduct;
    EditText editName;
    EditText editgia;
    Context mcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__chi__tiet__mon__an);



        recyclerView = findViewById(R.id.rv_CTMA);

        mMonAn = new ArrayList<MonAn>();
        for (int i = 1; i <= 2; i++) {
            mMonAn.add(new MonAn("Món "+i , "10.000"));
        }

        adapter = new DanhSachMonAnAdapter(mMonAn, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void openThanhToan(View view) {

        Intent intent = new Intent(this, activity_Thanh_Toan_TaiKhoan.class);
        startActivity(intent);
    }

    public void backChonban(View view) {
        Intent intent = new Intent(this, Activity_HienThiBanAn.class);
        startActivity(intent);
    }
    public void loadthongtin()
    {


    }
}
