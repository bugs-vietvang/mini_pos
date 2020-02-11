package com.example.tranquangthien.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tranquangthien.Model.BanAn;
import com.example.tranquangthien.Model.MonAn;
import com.example.tranquangthien.R;

import java.util.List;

public class DanhSachMonAnAdapter extends RecyclerView.Adapter {

    private List<MonAn> mMonAn;
    private Context mContext;
    public DanhSachMonAnAdapter(List _MonAn, Context mContext) {
        this.mMonAn = _MonAn;
        this.mContext = mContext;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View monanView = inflater.inflate(R.layout.item__hien_thi_mon_an, parent, false);

            DanhSachMonAnAdapter.ViewHolder viewHolder = new DanhSachMonAnAdapter.ViewHolder(monanView);
            return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                       MonAn monAn = mMonAn.get(position);
                         ((ViewHolder)(holder)).tenMonAn.setText(monAn.getTENMONAN());
                         ((ViewHolder)(holder)).giaTien.setText(monAn.getGIATIEN());
    }

    @Override
    public int getItemCount() {
        return mMonAn.size();
    }

     public static class ViewHolder extends RecyclerView.ViewHolder {
            private View itemview;
            public TextView tenMonAn, giaTien;
            public ViewHolder(View itemView) {
                super(itemView);
                itemview = itemView;
                tenMonAn = itemView.findViewById(R.id.txtTenMonAn);
                giaTien = itemView.findViewById(R.id.txtGiaTien);
                tenMonAn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(),tenMonAn.getText() +" | " + " Được thêm vào", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }



}
