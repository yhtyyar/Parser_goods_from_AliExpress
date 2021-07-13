package controller;

import repository.HttpConnector;
import repository.IOConnector;

public class GoodsController {

    private final HttpConnector httpConnector;
    private final IOConnector ioConnector;

    public GoodsController(HttpConnector httpConnector,IOConnector ioConnector ) {
        this.httpConnector = httpConnector;
        this.ioConnector = ioConnector;
    }


    public void startParsing(int quantity) {

        int numberOfRepetitions = quantity / 10;

        for (int i = 0; i < numberOfRepetitions; i++) {
            String request = httpConnector.getConnection(i);
            ioConnector.addGoodsToArray(request);
        }

        ioConnector.saveToFile();
    }
}
