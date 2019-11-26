package com.dicoding.tapembelajaranbiologi.data;

import com.dicoding.tapembelajaranbiologi.model.Bahan;

import java.util.ArrayList;

public class BahanData {
    public static String[][] data = new String[][]{
            {"Daun Rhoeo Discolor", "https://2.bp.blogspot.com/-RGCPWYVT4Bk/VxD1-wRewTI/AAAAAAAAAHg/kETVno__g1gD0ln8tJ0JLkGgO0lpkrYyQCLcB/s1600/daun%2Bungu.jpg"},
            {"Kecambah Kacang Hijau", "https://s3-ap-southeast-1.amazonaws.com/nia.ilmubudidaya.com/bulk/2018/01/01102237/Daizu-moyashi_comp_comp2-300x200.jpg"},
            {"Aquades", "https://www.quimicos-shoponline.com/113-thickbox_default_2x/desengrase-por-ultrasonidos-aquades.jpg"}
    };

    public static ArrayList<Bahan> getListData(){
        Bahan bahan = null;
        ArrayList<Bahan> list = new ArrayList<>();
        for (String[] aData : data) {
            bahan = new Bahan();
            bahan.setNama_bahan(aData[0]);
            bahan.setFoto_bahan(aData[1]);

            list.add(bahan);
        }

        return list;
    }
}
