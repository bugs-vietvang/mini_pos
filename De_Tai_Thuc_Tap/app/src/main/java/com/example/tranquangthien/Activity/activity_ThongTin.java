package com.example.tranquangthien.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tranquangthien.Adapter.DanhSachMonAnAdapter;
import com.example.tranquangthien.Model.MonAn;
import com.example.tranquangthien.R;
import com.example.tranquangthien.TruyVan.SQLiteHelper;
import com.example.tranquangthien.TruyVan.TruyVanGoiMon;

import java.util.ArrayList;

public class activity_ThongTin extends AppCompatActivity {
    RecyclerView recyclerView;
    DanhSachMonAnAdapter adapter;
    ArrayList<MonAn> mMonAn;
    boolean isupdate;
    int idproduct;
   TextView name, gia;

    //Intent: idproduct, isupdate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__thong_tin);
        AnhXa();
        recyclerView = findViewById(R.id.rv_thongtinchonmon);

        mMonAn = new ArrayList<MonAn>();
        for (int i = 1; i < 2; i++) {
            mMonAn.add(new MonAn("Món "+i , "10.000"));
        }

        adapter = new DanhSachMonAnAdapter(mMonAn, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        int spanCount = 2;
//        int orientation = GridLayoutManager.VERTICAL;
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
//        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(gridLayoutManager);

    }

    private void AnhXa() {

        name = (TextView)findViewById(R.id.txtTenMonAn);
        gia = (TextView)findViewById(R.id.txtGiaTien);

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

    public void LoadThongTin()
    {
    }
}
