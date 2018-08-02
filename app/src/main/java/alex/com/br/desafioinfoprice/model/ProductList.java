package alex.com.br.desafioinfoprice.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductList {
    @SerializedName("data")
    private ArrayList<Product> data;

    public ArrayList<Product> getProductArrayList() {
        return data;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.data = productArrayList;
    }
}
