package com.andys0723.Service.Impl;
/**
 * Name: Andy Tsai
 * Date: 2018-4-29
 * This class is responsible for calculating the min, max and average prices
 */
import com.andys0723.Model.Stock;
import com.andys0723.Service.CalculateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CalculatePricesImp implements CalculateDataService{

    @Autowired
    List<Stock> stocks;

    @Override
    public void calculate() {

        for(Stock stock: stocks){
            calcuateStockPrices(stock);
        }
    }

    private void calcuateStockPrices(Stock stock){
        double maxPrices = Double.MIN_VALUE;
        double minPrices = Double.MAX_VALUE;
        double sumPrices = 0.0;
        double avgPrices = 0.0;

        for(double price: stock.getPrices()){
            if(price > maxPrices ){
                maxPrices = price;
            }

            if(price < minPrices){
                minPrices = price;
            }

            sumPrices+=price;
        }

        avgPrices = sumPrices/stock.getPrices().size();
        stock.setMaxPrice(maxPrices);
        stock.setMinPrice(minPrices);
        stock.setAveragePrice(avgPrices);
//
//        System.out.println("Max Prices:" + maxPrices);
//        System.out.println("Min Prices:" + minPrices);
//        System.out.println("Sum Prices:" + sumPrices);
//        System.out.println("avg Prices:" + avgPrices);
    }
}
