package controller;

import model.Goods;
import service.GoodsService;

import java.util.ArrayList;
import java.util.List;

public class GoodsController {

    private final GoodsService goodsService;
    private final List<Goods> goodsList = new ArrayList<>();

    public GoodsController() {
        this.goodsService = new GoodsService();
    }


    public List<Goods> startParsing(int quantityGoods) {
        goodsList.addAll(goodsService.startParsing(quantityGoods));

        return goodsList;
    }
}
