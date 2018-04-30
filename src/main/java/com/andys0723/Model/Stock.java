package com.andys0723.Model;
/**
 * Name: Andy Tsai
 * Date: 2018-4-29
 * This class hold the data of each stock
 **/
import java.util.ArrayList;
import java.util.List;

public class Stock {

    private String Id;
    private List<Double> prices;
    private double averagePrice;
    private double maxPrice;
    private double minPrice;

    public Stock(){
        this.prices = new ArrayList<>();
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public List<Double> getPrices() {
        return prices;
    }

    public void setPrices(List<Double> prices) {
        this.prices = prices;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }
}
