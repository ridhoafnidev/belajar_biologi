package com.dicoding.tapembelajaranbiologi.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.dicoding.tapembelajaranbiologi.utils.Api.BaseApiService;
import com.dicoding.tapembelajaranbiologi.utils.Api.UtilsApi;
import com.dicoding.tapembelajaranbiologi.utils.Tools;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import com.dicoding.tapembelajaranbiologi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrasiActivity extends AppCompatActivity {
    @BindView(R.id.et_nama_lengkap) EditText etNamaLengkap;
    @BindView(R.id.et_username) EditText etUsername;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.et_kelas) EditText etKelas;
    @BindView(R.id.et_mata_pelajaran) EditText etMataPelajaran;
    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        initToolbar();
        initComponent();
    }
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Registrasi Akun");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.green_400);
    }

    private void initComponent() {
        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();

        (findViewById(R.id.et_kelas)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAgeDialog(v);
            }
        });

        (findViewById(R.id.tv_sign_in)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrasiActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });

        (findViewById(R.id.fab_register)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestRegister();
            }
        });

    }

    private void requestRegister(){
        boolean isEmpty = false;

        if (etNamaLengkap.getText().toString().equalsIgnoreCase("")){
            isEmpty = true;
            Toast.makeText(getApplicationContext(), "Nama Lengkap Masih Kosong", Toast.LENGTH_SHORT).show();
        }

        if (etUsername.getText().toString().equalsIgnoreCase("")){
            isEmpty = true;
            Toast.makeText(getApplicationContext(), "Username Masih Kosong", Toast.LENGTH_SHORT).show();
        }

        if (etPassword.getText().toString().equalsIgnoreCase("")){
            isEmpty = true;
            Toast.makeText(getApplicationContext(), "Password Masih Kosong", Toast.LENGTH_SHORT).show();
        }

        if (etKelas.getText().toString().equalsIgnoreCase("")){
            isEmpty = true;
            Toast.makeText(getApplicationContext(), "Kelas Masih Kosong", Toast.LENGTH_SHORT).show();
        }

        if (etMataPelajaran.getText().toString().equalsIgnoreCase("")){
            isEmpty = true;
            Toast.makeText(getApplicationContext(), "Mata Pelajaran Masih Kosong", Toast.LENGTH_SHORT).show();
        }

        if (isEmpty == false){
            loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);

            mApiService.registerRequest(etNamaLengkap.getText().toString(),
                    etUsername.getText().toString(),
                    etPassword.getText().toString(),
                    etKelas.getText().toString(),
                    etMataPelajaran.getText().toString())
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()){
                                Log.i("debug", "onResponse: Berhasil");
                                loading.dismiss();
                                try {
                                    JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                    if (jsonRESULTS.getString("error").equals("false")){
                                        Toast.makeText(mContext, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(mContext, LoginActivity.class));
                                    } else {
                                        String error_message = jsonRESULTS.getString("error_msg");
                                        Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                Log.i("debug", "onResponse: Gagal");
                                loading.dismiss();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                            Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

    }

    private void showAgeDialog(final View v) {
        final String[] array = new String[]{
                "VIII"
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Kelas");
        builder.setSingleChoiceItems(array, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ((EditText) v).setText(array[i]);
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(RegistrasiActivity.this, LoginActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }
}
