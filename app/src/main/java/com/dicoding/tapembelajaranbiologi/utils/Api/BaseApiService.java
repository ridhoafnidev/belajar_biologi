package com.dicoding.tapembelajaranbiologi.utils.Api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BaseApiService {

    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/login.php
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);

    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/register.php

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("nama") String nama,
                                       @Field("username") String username,
                                       @Field("password") String password,
                                       @Field("kelas") String kelas,
                                       @Field("mata_pelajaran") String mata_pelajaran);

    @GET("murid.php/murid")
    Call<ResponseBody> getProfil(@Path("id") String id);

    /*
    @GET("semuamurid")
    Call<ResponseDosen> getSemuaDosen();

    @GET("dosen/{namadosen}")
    Call<ResponseDosenDetail> getDetailDosen(@Path("namadosen") String namadosen);

    @GET("matkul")
    Call<ResponseMatkul> getSemuaMatkul();

    @FormUrlEncoded
    @POST("matkul")
    Call<ResponseBody> simpanMatkulRequest(@Field("nama_dosen") String namadosen,
                                           @Field("matkul") String namamatkul);

    @DELETE("matkul/{idmatkul}")
    Call<ResponseBody> deteleMatkul(@Path("idmatkul") String idmatkul);
    */
}
