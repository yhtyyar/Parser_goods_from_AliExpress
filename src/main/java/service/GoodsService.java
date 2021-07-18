package service;

import model.Goods;
import repository.GoodsRepository;
import repository.IOConnector;

import java.util.ArrayList;
import java.util.List;

public class GoodsService {

    private final IOConnector ioConnector;
    private final GoodsRepository goodsRepository;
    private final List<Goods> goodsList = new ArrayList<>();

    public GoodsService() {
        ioConnector = new IOConnector();
        goodsRepository = new GoodsRepository();
    }

    public List<Goods> startParsing(int quantityGoods) {
        int numberOfRepetitions = quantityGoods / 10;

        for (int i = 0; i < numberOfRepetitions; i++) {
            goodsList.addAll(goodsRepository.addGoodsToArray(numberOfRepetitions));
        }
        ioConnector.saveToFile();
        return goodsList;
    }
}
