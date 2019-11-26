package com.dicoding.tapembelajaranbiologi.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dicoding.tapembelajaranbiologi.R;
import com.dicoding.tapembelajaranbiologi.adapter.BahanAdapter;
import com.dicoding.tapembelajaranbiologi.data.BahanData;
import com.dicoding.tapembelajaranbiologi.model.Bahan;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BahanFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Bahan> list = new ArrayList<>();


    public BahanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bahan, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        list.addAll(BahanData.getListData());
        showRecyclerList();

        return view;
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        BahanAdapter listBahanAdapter = new BahanAdapter(getActivity());
        listBahanAdapter.setListBahan(list);
        recyclerView.setAdapter(listBahanAdapter);
    }

}
