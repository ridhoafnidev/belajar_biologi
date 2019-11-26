package com.dicoding.tapembelajaranbiologi.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dicoding.tapembelajaranbiologi.R;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll_kompetensi_inti, ll_kompetensi_dasar, ll_indikator, ll_tujuan_praktikum, ll_alat_bahan, ll_prosedur_praktikum;
    LinearLayout ll_hasil_praktikum, ll_evaluasi, ll_info_aplikasi, ll_profil, ll_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll_kompetensi_inti = findViewById(R.id.ll_kompetensi_inti);
        ll_kompetensi_dasar = findViewById(R.id.ll_kompetensi_dasar);
        ll_indikator = findViewById(R.id.ll_indikator);
        ll_tujuan_praktikum = findViewById(R.id.ll_tujuan_praktikum);
        ll_alat_bahan = findViewById(R.id.ll_alat_bahan);
        ll_prosedur_praktikum = findViewById(R.id.ll_prosedur_praktikum);
        ll_hasil_praktikum = findViewById(R.id.ll_hasil_praktikum);
        ll_evaluasi = findViewById(R.id.ll_evaluasi);
        ll_info_aplikasi = findViewById(R.id.ll_info_aplikasi);
        ll_profil = findViewById(R.id.ll_profil);
        ll_logout = findViewById(R.id.ll_logout);

        ll_kompetensi_inti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KompetensiIntiActivity.class);
                startActivity(intent);
            }
        });

        ll_kompetensi_dasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KompetensiDasarActivity.class);
                startActivity(intent);
            }
        });

        ll_indikator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IndikatorActivity.class);
                startActivity(intent);
            }
        });

        ll_tujuan_praktikum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TujuanPraktikumActivity.class);
                startActivity(intent);
            }
        });

        ll_alat_bahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlatBahanActivity.class);
                startActivity(intent);
            }
        });

        ll_prosedur_praktikum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProsedurPraktikumActivity.class);
                startActivity(intent);
            }
        });

        ll_hasil_praktikum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Klik Hasil Praktikum", Toast.LENGTH_SHORT).show();
            }
        });

        ll_evaluasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Klik Evaluasi", Toast.LENGTH_SHORT).show();
            }
        });

        ll_info_aplikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setCancelable(true);
                alertDialogBuilder.setTitle("Info Aplikasi");
                alertDialogBuilder.setIcon(R.drawable.ic_logo);

                LayoutInflater inflater = getLayoutInflater();

                View dialogView = inflater.inflate(R.layout.dialog_info_aplikasi, null);

                alertDialogBuilder.setView(dialogView);

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        ll_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Klik Profil", Toast.LENGTH_SHORT).show();
            }
        });

        ll_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Klik Logout", Toast.LENGTH_SHORT).show();
            }
        });


    }
}