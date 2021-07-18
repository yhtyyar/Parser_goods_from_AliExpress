package repository;

import com.google.gson.Gson;
import model.Goods;
import model.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoodsRepository {

    public static final List<String> itemsList = new ArrayList<>();

    private static final String TRIMMED_STR = "/\\*\\*/jQuery.*\\w\\(";
    private static final Gson gson = new Gson();
    private static final Pattern pattern = Pattern.compile(TRIMMED_STR);
    private final HttpConnector httpConnector;

    public GoodsRepository() {
        httpConnector = new HttpConnector();
    }


    public List<Goods> addGoodsToArray(int repetitionNumber) {

        Result result  =  convertingFromJSON(httpConnector.getConnection(repetitionNumber));

        List<Goods> goods = new ArrayList<>();
        if (result != null) {
            goods = result.getGoodsList();

            for (Goods gds : goods) {
                itemsList.add(gds.toString());
            }

        }
        return  goods;
    }

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
}


