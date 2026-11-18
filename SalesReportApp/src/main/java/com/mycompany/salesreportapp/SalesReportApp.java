/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.salesreportapp;

/**
 *
 * @author thape
 */
import java.util.Scanner;

public class SalesReportApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] names = {
            "Cozy Nights Monarch mattress", 
            "Restonic Barbados mattress", 
            "Sealy Phuket mattress"
        };
        int[][] sales = new int[3][3];

        // Ask for user input
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + names[i] + ": ");
                sales[i][j] = scanner.nextInt();
            }
            System.out.println();
        }

        // Creating objects and printing
        Product productReport = new Product(names, sales);
        PrintProduct printer = new PrintProduct();

        printer.printReportHeader();
        printer.printTotalSales(productReport.GetTotalProductsSold());
        printer.printAverageSales(productReport.GetAverageProductSold());
        printer.printMostPopularProduct(productReport.GetMostPopularProduct());

        scanner.close();
    }
}
