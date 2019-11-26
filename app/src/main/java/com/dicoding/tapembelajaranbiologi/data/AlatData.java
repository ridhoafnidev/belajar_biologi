package com.dicoding.tapembelajaranbiologi.data;

import com.dicoding.tapembelajaranbiologi.model.Alat;

import java.util.ArrayList;

public class AlatData {
    public static String[][] data = new String[][]{
            {"Mikroskop", "https://ecs7.tokopedia.net/img/cache/700/product-1/2017/4/18/18426938/18426938_95dadb2a-1ea4-43a0-a783-191322490f93_600_600.jpg"},
            {"Silet", "https://cdn2.tstatic.net/bogor/foto/bank/images/fungsi-dari-lubang-ditengah-silet_20160708_214137.jpg"},
            {"Pipet Tetes", "https://allkes.com/wp-content/uploads/2018/09/132244125_b0f115b6-fa40-4973-949f-bd32f92bdd0c_500_500_large.jpg"},
            {"Kaca Penutup", "https://ae01.alicdn.com/kf/HTB1OYaUL3HqK1RjSZFkq6x.WFXay/100-Pcs-Profesional-Kaca-Penutup-Kaca-Tutup-Cover-Mikroskop-18X18-Mm-Mikroskop-Slide-Mencakup-Grosir.jpg"},
            {"Kaca Preparat", "https://cdn.shopify.com/s/files/1/1794/7341/products/182534696_4859a14b-12fc-4c8e-a865-49ad40e4b91d_600_624_large.jpg?v=1495531728"},
            {"Tisu", "https://statik.tempo.co/data/2017/04/12/id_598113/598113_620.jpg"}
    };

    public static ArrayList<Alat> getListData(){
        Alat alat = null;
        ArrayList<Alat> list = new ArrayList<>();
        for (String[] aData : data) {
            alat = new Alat();
            alat.setNama_alat(aData[0]);
            alat.setFoto_alat(aData[1]);

            list.add(alat);
        }

        return list;
    }
}
