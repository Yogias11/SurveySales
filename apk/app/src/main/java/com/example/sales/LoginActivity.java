package com.example.sales;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.sales.api.ApiRequest;
import com.example.sales.api.RetroServer;
import com.example.sales.fragment.HomeFragment;
import com.example.sales.model.ResponseUserModel;
import com.example.sales.model.UserModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etPass;
    EditText etUname;
    ProgressDialog pd;
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUname = findViewById(R.id.tvUname);
        etPass = findViewById(R.id.tvPass);
        pd = new ProgressDialog(LoginActivity.this);
        pd.setMessage("loading....");


        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.show();
                ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
                Call<ResponseUserModel> login = api.login(etUname.getText().toString(), etPass.getText().toString());
                login.enqueue(new Callback<ResponseUserModel>() {
                    @Override
                    public void onResponse(@NotNull Call<ResponseUserModel> call, Response<ResponseUserModel> response) {
                        pd.dismiss();
                        Log.d(TAG, "response : " + response.toString());
                        ResponseUserModel res = response.body();
                        List<UserModel> user = res.getResult();
                        if (res.getKode().equals("1")){
                            Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("iduser", user.get(0).getIduser());
//                            intent.putExtra("username", user.get(1).getUsername());
//                            intent.putExtra("fullname", user.get(1).getFullname());
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseUserModel> call, @NotNull Throwable t) {
                        Log.d(TAG, "error : " + t.getMessage());
                    }
                });

            }
        });

    }

}