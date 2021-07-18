package repository;

import java.io.*;
import java.util.List;

public class IOConnector {

    private static final String FILE_NAME = "src/main/resources/goods.csv";
    private static final List<String> itemsList = GoodsRepository.itemsList;

    public void saveToFile() {

        try (PrintWriter printWriter = new PrintWriter(FILE_NAME)) {

            for (String str : itemsList) {
                printWriter.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Полученные данные сохранены в файле goods.csv");
    }
}
