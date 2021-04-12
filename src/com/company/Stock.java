package com.company;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Stock {


    public Double cash;
    public Double gain;
    public String stockSymbol;
    public Double  stockPrice;
    public Double share;


    public Stock() {
       cash = 10000.00;
       gain = 0.0;
       stockSymbol = null;
       share = 0.0;
       stockPrice = 0.0;


    }
    public Stock(Double cash, String StockSymbol){
        this.cash = cash;
        gain = 0.0;
        this.stockSymbol = stockSymbol;
        share = 0.0;
    }

    public Double request() throws IOException, InterruptedException {
        stockSymbol = "NIO";
        if( cash == 0.0 || stockSymbol == null){
            return null;
        }
        String url = String.format("https://finnhub.io/api/v1/quote?symbol=%s&token=",stockSymbol);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-Finnhub-Token", "c1oatn237fkqrr9sf2c0")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String currentPrice = (response.body().split(":"))[1].split(",")[0];
        return Double.valueOf(currentPrice);
    }
    public boolean buy(Double price){
        if( cash <= 0){
            return false;
        }
        share = cash / price;
        stockPrice = price;
        cash = 0.0;
        return true;

    }
    public boolean sell(Double price){
        if( share <=0 ){
            return false;
        }
        cash = share * price;
        stockPrice = 0.0;
        share = 0.0;
        return true;

    }
    public boolean initialTransaction()throws IOException, InterruptedException{
        Double price = request();
        if( price == null){
            return false;
        }
        buy(price);
        System.out.println(price);
        return true;
    }
    public Double getCash() {
        return cash;
    }
    public Double getGain() {
        return gain;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public Double getShare() {
        return share;
    }

    public void transaction() throws IOException, InterruptedException{
        Double price = request();
        if( price> stockPrice ){
            sell(price);
        }

    }
}
