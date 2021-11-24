package com.da.daCryptApp.service;

import com.da.daCryptApp.dao.RealtimeCurrencyExchangeRateDAO;
import com.da.daCryptApp.entity.RealtimeCurrencyExchangeRate;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class RealtimeCurrencyExchangeRateServiceImplementation<realtimeCurrencyExchangeRate> implements RealtimeCurrencyExchangeRateService {

    @Autowired
    private RealtimeCurrencyExchangeRateDAO realtimeCurrencyExchangeRateDAO;

    @Override
    @Transactional
    public List<RealtimeCurrencyExchangeRate> getRealtimeCurrencyExchangeRate() {
        return realtimeCurrencyExchangeRateDAO.getRealtimeCurrencyExchangeRate();
    }

    @Transactional
    @Override
    public void saveExchangeRate() {


        RealtimeCurrencyExchangeRate realtimeCurrencyExchangeRate = new RealtimeCurrencyExchangeRate();

        JSONParser parser = new JSONParser();

        HttpRequest request_daily = HttpRequest.newBuilder()
                .uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?from_currency=BTC&function=CURRENCY_EXCHANGE_RATE&to_currency=USD"))
                .header("x-rapidapi-key", "0de12c6716mshc9a0edac6f3fdd0p18f951jsn923a10990321")
                .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            HttpResponse<String> responseDaily =
                    HttpClient.newHttpClient().send(request_daily, HttpResponse.BodyHandlers.ofString());

            String dailyExchangeRate = responseDaily.body();

            FileOutputStream outputStream = new FileOutputStream("dailyExchangeRate.json");
            byte[] strToBytesD = dailyExchangeRate.getBytes();
            outputStream.write(strToBytesD);
            outputStream.close();

            FileReader reader = new FileReader("dailyExchangeRate.json");


            JSONArray exchangeRatesArray = (JSONArray) parser.parse(reader);

            List<RealtimeCurrencyExchangeRate> realtimeCurrencyExchangeRateList = new ArrayList<>();
            for(Object items : exchangeRatesArray) {
                JSONObject exchangeRateJsonObject = (JSONObject) items;

                String fromCurrencyShortName = (String) exchangeRateJsonObject.get("1. From_Currency Code");
                String fromCurrencyFullName = (String) exchangeRateJsonObject.get("2. From_Currency Name");
                String toCurrencyShortName = (String) exchangeRateJsonObject.get("3. To_Currency Code");
                String toCurrencyFullName = (String) exchangeRateJsonObject.get("4. To_Currency Name");
                double exchangeRate = (Double) exchangeRateJsonObject.get("5. Exchange Rate");
                String lastRefreshed = (String) exchangeRateJsonObject.get("6. Last Refreshed");
                String timeZone = (String) exchangeRateJsonObject.get("7. Time Zone");
                double bidPrice = (Double) exchangeRateJsonObject.get("8. Bid Price");
                double askPrice = (Double) exchangeRateJsonObject.get("9. Bid Price");


                realtimeCurrencyExchangeRate =
                        new RealtimeCurrencyExchangeRate(fromCurrencyShortName, fromCurrencyFullName, toCurrencyShortName,
                                toCurrencyFullName, exchangeRate, lastRefreshed, timeZone, bidPrice, askPrice);

                realtimeCurrencyExchangeRateList.add(realtimeCurrencyExchangeRate);

            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        realtimeCurrencyExchangeRateDAO.saveRealtimeCurrencyExchangeRate(realtimeCurrencyExchangeRate);
    };




}

