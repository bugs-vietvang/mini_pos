package com.example.tranquangthien.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tranquangthien.Activity.Activity_HienThiBanAn;
import com.example.tranquangthien.Activity.activity_Chon_Mon;
import com.example.tranquangthien.Model.BanAn;
import com.example.tranquangthien.R;

import java.util.List;

public class HienThiBanAnAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<BanAn> mBanAn;
        private Context mContext;

        public HienThiBanAnAdapter(List _BanAN, Context mContext) {
            this.mBanAn = _BanAN;
            this.mContext = mContext;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View bananView = inflater.inflate(R.layout.item_ban_an, parent, false);

            ViewHolder viewHolder = new ViewHolder(bananView);
            return viewHolder;

        }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BanAn banAn = mBanAn.get(position);
        ((ViewHolder)(holder)).TenBanAn.setText(banAn.getTENBAN());
//        ((ViewHolder)(holder)).TrangThai.setText(banAn.getTRANGTHAI()+"");
    }

        @Override
        public int getItemCount() {
            return mBanAn.size();
        }
        public static class ViewHolder extends RecyclerView.ViewHolder {
            private View itemview;
            public TextView TenBanAn;
            public ImageView imgview;
//            BanAn banAn = mBanAn.get(position);
            public ViewHolder(final View itemView) {
                super(itemView);
                itemview = itemView;
                imgview= itemView.findViewById(R.id.imgSlot);
                TenBanAn = itemView.findViewById(R.id.tvSlot);
                imgview.setOnClickListener(new View.OnClickListener() {
                    public Activity mContext;

                    @Override
                    public void onClick(View view) {
//                        Intent intent1 = ((activity_Chon_Mon)Context).getIntent();
//                        int manhanvien = intent1.getIntExtra("manhanvien",0);
//                        Intent intent = new Intent(Context,activity_Chon_Mon.class);
//                        intent.putExtra("maban",banAn.getMABAN());
//                        intent.putExtra("tenban",banAn.getTENBAN());
//                        intent.putExtra("manhanvien",manhanvien);
//                        mContext.startActivity(intent);
                        Toast.makeText(view.getContext(),TenBanAn.getText() +" | " + " Chưa Đặt", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }


    }

