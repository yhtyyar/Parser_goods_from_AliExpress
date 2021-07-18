package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Goods {

    @SerializedName("productId")
    @Expose
    private long productId;

    @SerializedName("sellerId")
    @Expose
    private long sellerId;

    @SerializedName("productImage")
    @Expose
    private String productImage;

    @SerializedName("productDetailUrl")
    @Expose
    private String productDetailUrl;

    @SerializedName("productTitle")
    @Expose
    private String productTitle;

    @SerializedName("minPrice")
    @Expose
    private String minPrice;

    @SerializedName("maxPrice")
    @Expose
    private String maxPrice;

    @SerializedName("oriMinPrice")
    @Expose
    private String oriMinPrice;

    @SerializedName("oriMaxPrice")
    @Expose
    private String oriMaxPrice;

    @SerializedName("discount")
    @Expose
    private int discount;

    @SerializedName("promotionId")
    @Expose
    private long promotionId;

    @SerializedName("startTime")
    @Expose
    private long startTime;

    @SerializedName("endTime")
    @Expose
    private long endTime;

    @SerializedName("phase")
    @Expose
    private int phase;

    @SerializedName("orders")
    @Expose
    private Long orders;

    @SerializedName("shopUrl")
    @Expose
    private String shopUrl;

    @SerializedName("trace")
    @Expose
    private String trace;


    @Override
    public String toString() {
        return "Goods {" + "\n" +
                "productId= " + productId + "\n" +
                "sellerId= " + sellerId + "\n" +
                "productImage= " + productImage  + "\n" +
                "productDetailUrl= " + productDetailUrl  + "\n" +
                "productTitle= " + productTitle  + "\n" +
                "minPrice= " + minPrice + "\n" +
                "maxPrice= " + maxPrice + "\n" +
                "oriMinPrice= " + oriMinPrice  + "\n" +
                "oriMaxPrice= " + oriMaxPrice  + "\n" +
                "discount= " + discount + "\n" +
                "promotionId= " + promotionId + "\n" +
                "startTime= " + startTime + "\n" +
                "endTime= " + endTime + "\n" +
                "phase= " + phase + "\n" +
                "orders= " + orders + "\n" +
                "shopUrl= " + shopUrl  + "\n" +
                "trace= " + trace  + "\n" +
                "}";
    }
}
