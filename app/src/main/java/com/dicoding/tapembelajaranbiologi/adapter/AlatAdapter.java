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
import com.dicoding.tapembelajaranbiologi.model.Alat;

import java.util.ArrayList;

public class AlatAdapter extends RecyclerView.Adapter<AlatAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Alat> listAlat;


    public AlatAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Alat> getListAlat() {
        return listAlat;
    }

    public void setListAlat(ArrayList<Alat> listAlat) {
        this.listAlat = listAlat;
    }



    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_alat, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, final int position) {
        categoryViewHolder.tv_nama_alat.setText(getListAlat().get(position).getNama_alat());
        Glide.with(context)
                .load(getListAlat().get(position).getFoto_alat())
                .into(categoryViewHolder.iv_foto_alat);

    }

    @Override
    public int getItemCount() {
        return getListAlat().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama_alat;
        ImageView iv_foto_alat;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_foto_alat = itemView.findViewById(R.id.iv_foto_alat);
            tv_nama_alat = itemView.findViewById(R.id.tv_nama_alat);
        }
    }
}
