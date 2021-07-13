package repository;

import com.google.gson.Gson;
import model.Goods;
import model.Result;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class IOConnector {

    private static final String FILE_NAME = "src/main/resources/goods.csv";
    public static final String TRIMMED_STR = "/\\*\\*/jQuery.*\\w\\(";
    private static final Pattern pattern = Pattern.compile(TRIMMED_STR);
    private static final Gson gson = new Gson();
    private static final List<String> itemsList = new ArrayList<>();
    AtomicInteger number = new AtomicInteger(0);


    public Result convertingFromJSON(String goods) {

        StringBuilder stringBuilder = new StringBuilder(goods);
        stringBuilder.setLength(stringBuilder.length() - 2);

        Matcher matcher = pattern.matcher(goods);

        if (matcher.find()) {

            stringBuilder.replace(matcher.start(), matcher.end(), "");
            return gson.fromJson(stringBuilder.toString(), Result.class);

        } else {
            System.out.println("Ошибка входных данных!");
            return null;
        }
    }


    public void addGoodsToArray(String request) {

        Result result = convertingFromJSON(request);

        if (result != null) {
            List<Goods> goodsList = result.getGoodsList();

            goodsList.stream().forEach(goods -> {

                System.out.println(" № " + number.incrementAndGet());
                itemsList.add(goods.toString());
                System.out.println(goods);
            });

        }
    }


    public void saveToFile() {

        try (PrintWriter printWriter = new PrintWriter(new File(FILE_NAME))) {

            for (String str : itemsList) {
                printWriter.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Данные сохранены в файле goods.csv");
    }
}
