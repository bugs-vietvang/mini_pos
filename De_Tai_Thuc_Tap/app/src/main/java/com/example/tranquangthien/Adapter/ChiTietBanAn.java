package com.example.tranquangthien.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.tranquangthien.Model.Order;
import com.example.tranquangthien.R;
import com.example.tranquangthien.TruyVan.TruyVanGoiMon;

import java.text.DecimalFormat;
import java.util.List;



public class ChiTietBanAn extends BaseAdapter implements View.OnClickListener, View.OnLongClickListener {

        //region khai báo
        private Activity activity;
        private List<Order> orderList;
        private ViewHolderChiTiet viewHolderChiTiet;
        private boolean kiemTraDaXuatBillChua = false;

        private TruyVanGoiMon truyVanGoiMon;
        //endregion

        public ChiTietBanAn(Activity activity, List<Order> orderList) {
            this.activity = activity;
            this.orderList = orderList;

            truyVanGoiMon = new TruyVanGoiMon(activity);
        }

        @Override
        public int getCount() {
            return orderList.size();
        }

        @Override
        public Object getItem(int i) {
            return orderList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return orderList.get(i).getMaOrder();
        }

        private class ViewHolderChiTiet {
            ImageView imgAnhMonAn;
            TextView txtTenMonAn, txtGiaTien;
            Button btnSoLuong;
            FrameLayout frameLayout;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View row = view;
            if (view == null){
                viewHolderChiTiet = new ViewHolderChiTiet();
                LayoutInflater inflater = (LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
//                row = inflater.inflate(R.layout.item_chi_tiet_ban,null);
//                viewHolderChiTiet.imgAnhMonAn = row.findViewById(R.id.imgAnhMonAn);
//                viewHolderChiTiet.txtTenMonAn = row.findViewById(R.id.txtTenMonAn);
//                viewHolderChiTiet.txtGiaTien = row.findViewById(R.id.txtGiaTienMonAn);
//                viewHolderChiTiet.btnSoLuong = row.findViewById(R.id.btnSoLuongMonDaGoi);
//                viewHolderChiTiet.frameLayout = row.findViewById(R.id.flItemChiTietBanAn);


                row.setTag(viewHolderChiTiet);
            }else{
                viewHolderChiTiet = (ViewHolderChiTiet) row.getTag();
            }

            final Order order = orderList.get(i);

            String tenMonAn = order.getTenMonAn();
            String anhMonAn = order.getAnhMonAn();
            String giaTien = order.getGiaTien();
            int soLuong = order.getSoLuong();

            DecimalFormat formatter = new DecimalFormat("#,###,###");
            int gia = Integer.parseInt(giaTien);
            String price = formatter.format(gia);

            Glide.with(activity).load(anhMonAn)
                    .apply(new RequestOptions().transform(new RoundedCorners(1)))
                    .into(viewHolderChiTiet.imgAnhMonAn);

            viewHolderChiTiet.txtGiaTien.setText(price);
            viewHolderChiTiet.txtTenMonAn.setText(tenMonAn);
            viewHolderChiTiet.btnSoLuong.setText(soLuong+"");

            Animation animation = AnimationUtils.loadAnimation(activity,R.anim.hieu_ung_list_view);
            row.startAnimation(animation);

            viewHolderChiTiet.frameLayout.setOnLongClickListener(this);

            int maban = truyVanGoiMon.layMaBanTuMaGoiMon(order.getMaOrder());
//            kiemTraDaXuatBillChua = truyVanKiemTraXuatBill.layKiemTraXuatBill(maban);

//            if ((order.getMaLoai() == 1 || order.getMaLoai() == 2) && !kiemTraDaXuatBillChua){
//                viewHolderChiTiet.btnSoLuong.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(activity, MayTinhSoLuongActivity.class);
//                        intent.putExtra("soluong", order.getSoLuong());
//                        intent.putExtra("mamonan",order.getMaMonAn());
//                        intent.putExtra("magoimon",order.getMaOrder());
//                        activity.startActivity(intent);
//                    }
//                });

            return null;
        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
    
