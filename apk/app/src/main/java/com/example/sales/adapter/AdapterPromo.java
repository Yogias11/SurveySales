package com.example.sales.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sales.R;
import com.example.sales.model.PromoModel;

import java.util.List;

public class AdapterPromo extends RecyclerView.Adapter<AdapterPromo.HolderData> {

    private Context ctx;
    private List<PromoModel> mList;

    public AdapterPromo(Context ctx, List<PromoModel> mList) {
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist1, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        PromoModel pm = mList.get(position);
        holder.txt1.setText(pm.getFullname());
        holder.txt2.setText(pm.getPromo());
        holder.pm = pm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder {
        TextView txt1, txt2;
        PromoModel pm;
        public HolderData(View v) {
            super(v);
            txt1 = v.findViewById(R.id.tvSales);
            txt2 = v.findViewById(R.id.tvPromo);
        }
    }
}
