package alex.com.br.desafioinfoprice.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BannerList {
    @SerializedName("data")
    private ArrayList<Banner> data;

    public ArrayList<Banner> getBannerArrayList() {
        return data;
    }

    public void setBannerArrayList(ArrayList<Banner> bannerArrayList) {
        this.data = bannerArrayList;
    }
}
