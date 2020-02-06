package com.example.tranquangthien.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.example.tranquangthien.Activity.TrangChuActivity;
import com.example.tranquangthien.Model.BanAn;
import com.example.tranquangthien.R;
import com.example.tranquangthien.TruyVan.TruyVanBanAn;
import com.example.tranquangthien.TruyVan.TruyVanGoiMon;

import java.util.List;

public class HienThiBanAnAdapter extends BaseAdapter implements View.OnLongClickListener {

    //region khai báo
    private Context context;
    private List<BanAn> banAnList;
    private ViewHolderBanAn viewHolderBanAn;
    private TruyVanBanAn truyVanBanAn;
    private Dialog dialog;
    private TruyVanGoiMon truyVanGoiMon;
    private FragmentManager fragmentManager;
    //endregion

    public HienThiBanAnAdapter(Context context, List<BanAn> banAnList) {
        this.context = context;
        this.banAnList = banAnList;
        truyVanBanAn = new TruyVanBanAn((Activity) context);
        truyVanGoiMon = new TruyVanGoiMon((Activity) context);
        fragmentManager = ((TrangChuActivity)context).getSupportFragmentManager();
    }

    @Override
    public int getCount() {
        return banAnList.size();
    }

    @Override
    public Object getItem(int position) {
        return banAnList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return banAnList.get(position).getMABAN();
    }

    public class ViewHolderBanAn{
        TextView txtTenBanAn;
        ImageView imgBanAn;
    }

    @Override
    public View getView(final int position , View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewHolderBanAn = new ViewHolderBanAn();
            view = inflater.inflate(R.layout.activity_item_hienthiban,viewGroup,false);
            viewHolderBanAn.imgBanAn = view.findViewById(R.id.imgSlot);
            viewHolderBanAn.txtTenBanAn = view.findViewById(R.id.tvSlot);

            view.setTag(viewHolderBanAn);
        }else{
            viewHolderBanAn = (ViewHolderBanAn) view.getTag();
        }

        if(banAnList.get(position).isDUOCCHON()){

        }else{

        }

        final BanAn banAn = banAnList.get(position);

        String tinhtrang = truyVanBanAn.layTinhTrangBanTheoMa(banAn.getMABAN());
        if (tinhtrang.equals("true")){
            viewHolderBanAn.imgBanAn.setImageResource(R.drawable.slot_not_empty);
        }else if (tinhtrang.equals("false")){
            viewHolderBanAn.imgBanAn.setImageResource(R.drawable.slot_order_empty);
        }

        viewHolderBanAn.txtTenBanAn.setText(banAn.getTENBAN());
        viewHolderBanAn.imgBanAn.setTag(position);

        final int maGoiMon = truyVanGoiMon.layMaGoiMonTheoMaBan(banAn.getMABAN(),"false");
        viewHolderBanAn.imgBanAn.setOnLongClickListener(this);

        return view;
    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

}


