package com.dicoding.tapembelajaranbiologi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.dicoding.tapembelajaranbiologi.R;
import com.dicoding.tapembelajaranbiologi.utils.Api.BaseApiService;
import com.dicoding.tapembelajaranbiologi.utils.Api.UtilsApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilActivity extends AppCompatActivity {
    EditText edt_username, edt_password, edt_nama_lengkap, edt_mata_pelajaran, edt_kelas;

    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper

        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);
        edt_nama_lengkap = findViewById(R.id.edt_nama_lengkap);
        edt_mata_pelajaran = findViewById(R.id.edt_mata_pelajaran);
        edt_kelas = findViewById(R.id.edt_kelas);

        mApiService.getProfil("4").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "sukses", Toast.LENGTH_SHORT).show();
                }else {

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
            }
        });
    }
}
