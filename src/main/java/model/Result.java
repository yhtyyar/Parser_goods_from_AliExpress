package model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("results")
    @Expose
    private List<Goods> goodsList;

    public List<Goods> getGoodsList() {
        return  goodsList;
    }


}