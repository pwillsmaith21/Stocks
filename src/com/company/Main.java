package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
	Stock stock_option = new Stock();
	stock_option.initialTransaction();
        System.out.println(stock_option.getShare()*stock_option.stockPrice);

    }
}
