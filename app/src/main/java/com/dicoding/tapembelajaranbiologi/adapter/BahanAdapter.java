package com.dicoding.tapembelajaranbiologi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dicoding.tapembelajaranbiologi.R;
import com.dicoding.tapembelajaranbiologi.model.Bahan;

import java.util.ArrayList;

public class BahanAdapter extends RecyclerView.Adapter<BahanAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Bahan> listBahan;


    public BahanAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Bahan> getListBahan() {
        return listBahan;
    }

    public void setListBahan(ArrayList<Bahan> listBahan) {
        this.listBahan = listBahan;
    }



    @NonNull
    @Override
    public BahanAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bahan, viewGroup, false);
        return new BahanAdapter.CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull BahanAdapter.CategoryViewHolder categoryViewHolder, final int position) {
        categoryViewHolder.tv_nama_bahan.setText(getListBahan().get(position).getNama_bahan());
        Glide.with(context)
                .load(getListBahan().get(position).getFoto_bahan())
                .into(categoryViewHolder.iv_foto_bahan);

    }

    @Override
    public int getItemCount() {
        return getListBahan().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama_bahan;
        ImageView iv_foto_bahan;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_foto_bahan = itemView.findViewById(R.id.iv_foto_bahan);
            tv_nama_bahan = itemView.findViewById(R.id.tv_nama_bahan);
        }
    }
}
