package view;

import controller.GoodsController;
import model.Goods;

import java.util.List;

public class GoodsView {

    public void start(int quantityGoods) {
        GoodsController goodsController = new GoodsController();
        List<Goods> goodsList = goodsController.startParsing(quantityGoods);

        for (Goods goods : goodsList) {
            System.out.println(goods.toString());
        }
    }
}
