package com.example.sales.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sales.MainActivity;
import com.example.sales.R;
import com.example.sales.api.ApiRequest;
import com.example.sales.api.RetroServer;
import com.example.sales.model.ResponseModel;
import com.example.sales.model.ResponseOrderModel;
import com.example.sales.model.TokoModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PenjualanFragment extends Fragment {

    Spinner spToko;
    ProgressDialog loading;
    EditText tvStok;
    Button btn;
    String iduser, idtoko;

    Context mContext;
    ApiRequest api;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_penjualan, container, false);
        if (getArguments() != null) {
            iduser = getArguments().getString("iduser");
        }
        tvStok = view.findViewById(R.id.tvStok1);
        mContext = getContext();
        api = RetroServer.getClient().create(ApiRequest.class);
        initSpinner();
        btn = view.findViewById(R.id.btnAdd);
        spToko = view.findViewById(R.id.spToko);
        spToko.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String select = parent.getItemAtPosition(position).toString();
                Toast.makeText(mContext, "Memilih Toko " + select, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
       return view;
    }

    public void initSpinner() {
        loading = ProgressDialog.show(mContext, null, "Harap tunggu ...", true, false);

        api.getToko().enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful()) {
                    loading.dismiss();
                    List<TokoModel> items = response.body().getResult();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < items.size(); i++){
                        listSpinner.add(items.get(i).getNm_toko());
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(mContext,
                            android.R.layout.simple_spinner_item, listSpinner);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spToko.setAdapter(arrayAdapter);
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data toko", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void sendData()
    {
        loading.dismiss();
        loading.setCancelable(false);
        loading.show();
        String stok = tvStok.getText().toString();
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseOrderModel> insert = api.insertOrder(iduser, idtoko, stok);
        insert.enqueue(new Callback<ResponseOrderModel>() {
            @Override
            public void onResponse(Call<ResponseOrderModel> call, Response<ResponseOrderModel> response) {
                loading.dismiss();

                ResponseOrderModel res = response.body();
                if (res.getKode().equals("1")) {
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getActivity(), res.getPesan(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseOrderModel> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(getActivity(), "Periksa Kembali Jaringan Anda !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}