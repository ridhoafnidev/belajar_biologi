package com.dicoding.tapembelajaranbiologi.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Alat implements Parcelable {
    private String foto_alat;
    private String nama_alat;

    public Alat() {
    }

    public Alat(String foto_alat, String nama_alat) {
        this.foto_alat = foto_alat;
        this.nama_alat = nama_alat;
    }

    public String getFoto_alat() {
        return foto_alat;
    }

    public void setFoto_alat(String foto_alat) {
        this.foto_alat = foto_alat;
    }

    public String getNama_alat() {
        return nama_alat;
    }

    public void setNama_alat(String nama_alat) {
        this.nama_alat = nama_alat;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.foto_alat);
        dest.writeString(this.nama_alat);
    }

    protected Alat(Parcel in) {
        this.foto_alat = in.readString();
        this.nama_alat = in.readString();
    }

    public static final Parcelable.Creator<Alat> CREATOR = new Parcelable.Creator<Alat>() {
        @Override
        public Alat createFromParcel(Parcel source) {
            return new Alat(source);
        }

        @Override
        public Alat[] newArray(int size) {
            return new Alat[size];
        }
    };
}
