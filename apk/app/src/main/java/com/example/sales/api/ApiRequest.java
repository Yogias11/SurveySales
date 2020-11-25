package com.example.sales.api;

import com.example.sales.model.ResponseModel;
import com.example.sales.model.ResponseOrderModel;
import com.example.sales.model.ResponsePromoModel;
import com.example.sales.model.ResponseUserModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequest {

    @GET("getToko.php")
    Call<ResponseModel> getToko();

    @GET("getPromo.php")
    Call<ResponsePromoModel> getPromo();

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseUserModel> login(@Field("username") String username,
                              @Field("password") String password);

    @FormUrlEncoded
    @POST("insertOrder.php")
    Call<ResponseOrderModel> insertOrder(@Field("iduser") String iduser,
                                         @Field("idtoko") String idtoko,
                                         @Field("stok") String stok);
}
