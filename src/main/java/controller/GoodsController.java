package controller;

import repository.HttpConnector;
import repository.IOConnector;

public class GoodsController {

    private final HttpConnector httpConnector = new HttpConnector();
    private final IOConnector ioConnector = new IOConnector();


    public void startParsing(int quantity) {

        int numberOfRepetitions = quantity / 10;

        for (int i = 0; i < numberOfRepetitions; i++) {
            String request = httpConnector.getConnection(i);
            ioConnector.addGoodsToArray(request);
        }

        ioConnector.saveToFile();
    }
}
