/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreportapp;

/**
 *
 * @author thape
 */
public class PrintProduct {
    public void printReportHeader() {
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("**************************************************");
    }
    public void printTotalSales(int total) {
        System.out.println("TOTAL PRODUCT SALES: " + total);
    }
    public void printAverageSales(double average) {
        System.out.printf("AVERAGE PRODUCT SALES: %.0f\n", average);
    }
    public void printMostPopularProduct(String product) {
        System.out.println("MOST POPULAR PRODUCT: " + product);
    }
}
