/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreportapp;

/**
 *
 * @author thape
 */
public class Product implements IProduct {
    private String[] productNames;
    private int[][] salesData;

    public Product(String[] productNames, int[][] salesData) {
        this.productNames = productNames;
        this.salesData = salesData;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                total += salesData[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int totalEntries = salesData.length * salesData[0].length;
        return (double) total / totalEntries;
    }

    @Override
    public String GetMostPopularProduct() {
        int highestSales = 0;
        String popularProduct = "";
        for (int i = 0; i < salesData.length; i++) {
            int currentProductTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                currentProductTotal += salesData[i][j];
            }
            if (currentProductTotal > highestSales) {
                highestSales = currentProductTotal;
                popularProduct = productNames[i] + "(" + highestSales + ")";
            }
        }
        return popularProduct;
    }
}
