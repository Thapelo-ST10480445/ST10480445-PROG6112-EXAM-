/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productguiapp;

/**
 *
 * @author thape
 */
// Q.2.5: This class implements the interface and does the actual math
public class ProductCalculations implements IProductCalculations {
    private double price;

    // Constructor to receive the price entered by the user
    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double GetVat() {
        // VAT is 15% of the product price
        return price * 0.15;
    }

    @Override
    public double GetCommission() {
        // Commission is 5% of the product price
        return price * 0.05;
    }

    @Override
    public double GetTotal() {
        // Total Sale Amount is Price + VAT + Commission
        return price + GetVat() + GetCommission();
    }
}
