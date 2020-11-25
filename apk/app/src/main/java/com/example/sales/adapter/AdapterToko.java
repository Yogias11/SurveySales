package com.example.sales.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sales.R;
import com.example.sales.model.TokoModel;

import java.util.List;

public class AdapterToko extends RecyclerView.Adapter<AdapterToko.HolderData> {

    private Context ctx;
    private List<TokoModel> mList;

    public AdapterToko(Context ctx, List<TokoModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        TokoModel tm = mList.get(position);
        holder.txt1.setText(tm.getNm_toko());
        holder.txt2.setText(tm.getAlmt_toko());
        holder.tm = tm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder {
        TextView txt1, txt2, txt3, txt4;

        TokoModel tm;
        public HolderData(@NonNull View view){
            super(view);

            txt1 = view.findViewById(R.id.tvToko);
            txt2 = view.findViewById(R.id.tvAlmt);
            txt3 = view.findViewById(R.id.tvLong);
            txt4 = view.findViewById(R.id.tvLat);
        }
    }
}
