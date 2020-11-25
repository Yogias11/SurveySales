package com.example.sales.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sales.R;
import com.example.sales.adapter.AdapterToko;
import com.example.sales.api.ApiRequest;
import com.example.sales.api.RetroServer;
import com.example.sales.model.ResponseModel;
import com.example.sales.model.TokoModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KontrolFragment extends Fragment {

    FloatingActionButton fab1;
    private RecyclerView rv;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager manager;
    private List<TokoModel> mItems = new ArrayList<>();
    ProgressDialog pd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kontrol, container, false);

        pd = new ProgressDialog(getContext());
        rv = view.findViewById(R.id.rvList);
        manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);

        pd.setMessage("Loading....");
        pd.setCancelable(false);
        pd.show();
        load();

        fab1 = view.findViewById(R.id.FAB);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new AddProductFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.frameLayout, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }

    public void load(){
        ApiRequest apiRequest = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseModel> getData = apiRequest.getToko();
        getData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                pd.hide();
                Log.d("Retro", "Response :" + response.body().getKode());
                mItems = response.body().getResult();

                mAdapter = new AdapterToko(getContext(), mItems);
                rv.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                pd.hide();
                Log.d("Retro", "Failed Load");
            }
        });
    }
}