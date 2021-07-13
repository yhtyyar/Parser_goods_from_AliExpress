package repository;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpConnector {

    public String getConnection(int quantity) {

        HttpGet getConnection = new HttpGet("https://gpsfront.aliexpress.com/getRecommendingResults.do?callback=" +
                "jQuery18308651937148592963_1618481732718&widget_id=5547572&platform=pc&limit=10&offset="
                + quantity * 10 + "&phase=1&productIds2Top=&postback=1618481735088");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(getConnection)) {

            if (response.getStatusLine().getStatusCode() != 200) {

                throw new IOException("Ошибка при попытке подключения!");
            }

            if (response.getEntity() != null) {
                return EntityUtils.toString(response.getEntity());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return " ";
    }
}
