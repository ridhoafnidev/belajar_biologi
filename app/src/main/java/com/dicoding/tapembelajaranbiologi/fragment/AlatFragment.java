package com.dicoding.tapembelajaranbiologi.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dicoding.tapembelajaranbiologi.R;
import com.dicoding.tapembelajaranbiologi.adapter.AlatAdapter;
import com.dicoding.tapembelajaranbiologi.data.AlatData;
import com.dicoding.tapembelajaranbiologi.model.Alat;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlatFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Alat> list = new ArrayList<>();


    public AlatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alat, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        list.addAll(AlatData.getListData());
        showRecyclerList();

        return view;
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        AlatAdapter listAlatAdapter = new AlatAdapter(getActivity());
        listAlatAdapter.setListAlat(list);
        recyclerView.setAdapter(listAlatAdapter);
    }

}
