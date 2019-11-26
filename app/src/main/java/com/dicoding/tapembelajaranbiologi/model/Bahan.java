package com.dicoding.tapembelajaranbiologi.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Bahan implements Parcelable {
    private String foto_bahan;
    private String nama_bahan;

    public Bahan() {
    }

    public Bahan(String foto_bahan, String nama_bahan) {
        this.foto_bahan = foto_bahan;
        this.nama_bahan = nama_bahan;
    }

    public String getFoto_bahan() {
        return foto_bahan;
    }

    public void setFoto_bahan(String foto_bahan) {
        this.foto_bahan = foto_bahan;
    }

    public String getNama_bahan() {
        return nama_bahan;
    }

    public void setNama_bahan(String nama_bahan) {
        this.nama_bahan = nama_bahan;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.foto_bahan);
        dest.writeString(this.nama_bahan);
    }

    protected Bahan(Parcel in) {
        this.foto_bahan = in.readString();
        this.nama_bahan = in.readString();
    }

    public static final Parcelable.Creator<Bahan> CREATOR = new Parcelable.Creator<Bahan>() {
        @Override
        public Bahan createFromParcel(Parcel source) {
            return new Bahan(source);
        }

        @Override
        public Bahan[] newArray(int size) {
            return new Bahan[size];
        }
    };
}
