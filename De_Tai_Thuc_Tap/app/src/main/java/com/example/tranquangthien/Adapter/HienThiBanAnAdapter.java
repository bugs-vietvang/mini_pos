package com.example.tranquangthien.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tranquangthien.Model.BanAn;
import com.example.tranquangthien.R;

import java.util.List;

public class HienThiBanAnAdapter extends RecyclerView.Adapter {

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
        holder.txtbenbanan.setText(banAn.getTENBAN());
        holder.txttrangthai.setText(banAn.getTRANGTHAI()+"");
    }

        @Override
        public int getItemCount() {
            return mBanAn.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            private View itemview;
            public TextView TenBanAn;
            public TextView Tranghai;
            public Button detail_button;

            public ViewHolder(View itemView) {
                super(itemView);
                itemview = itemView;
                TenBanAn = itemView.findViewById(R.id.txttenbanan);
                Tranghai = itemView.findViewById(R.id.txttrangthai);
                detail_button = itemView.findViewById(R.id.detail_button);
                detail_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(),Tranghai.getText() +" | " + " Demo function", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }


    }

