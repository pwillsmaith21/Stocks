package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.channels.FileLock;

public class Gui extends Frame {
    static final int WIDTH = 400;
    static final int HEIGHT = 400;
    Label price;
    Label cash;
    Label profit;
    Label shares;
    Label priceLabel;
    Label cashLabel;
    Label profitLabel;
    Label sharesLabel;


    public Gui() throws IOException, InterruptedException {
        setSize(WIDTH, HEIGHT);
        Stock stock = new Stock();
        stock.initialTransaction();
        setTitle( "Stock Bot");
        Panel mainPanel  = new Panel(new FlowLayout());
        add( mainPanel);
         price = new Label(stock.getStockPrice().toString());
         mainPanel.add(price, new GridLayout(1,1));
         cash = new Label( stock.getCash().toString());
         mainPanel.add(cash);
         profit = new Label(stock.getGain().toString());
         mainPanel.add(profit, new GridLayout(3,1));
        shares = new Label(stock.getShare().toString());
        mainPanel.add(shares, new GridLayout( 4,1 ));
        priceLabel = new Label("Price");
        mainPanel.add(priceLabel,new GridLayout(1,2));
        cashLabel = new Label("Cash");
        mainPanel.add(cashLabel,new GridLayout(2,2));
        profitLabel = new Label("Profit");
        mainPanel.add(profitLabel,new GridLayout(3,2));
        sharesLabel = new Label("Shares");
        mainPanel.add(sharesLabel, new GridLayout(4,2));



    }


}
