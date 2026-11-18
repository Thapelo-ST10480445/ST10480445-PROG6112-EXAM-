/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.salesreportapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    // Q.1.4 Unit Test 1
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        // 1. Setup (Arrange) - Create dummy data for the test
        String[] testNames = {"Product A", "Product B", "Product C"};
        int[][] testSales = {
            {10, 10, 10}, // Product A total: 30
            {20, 20, 20}, // Product B total: 60
            {30, 30, 30}  // Product C total: 90
        };
        
        // Create a new Product object using our dummy data
        Product testProduct = new Product(testNames, testSales);

        // 2. Expected Result
        // 30 + 60 + 90 = 180
        int expectedTotal = 180;

        // 3. Execute (Act) - Call the method we are testing
        int actualTotal = testProduct.GetTotalProductsSold();

        // 4. Verify (Assert) - Check if the actual matches expected
        assertEquals(expectedTotal, actualTotal, "The total products sold should be 180");
    }

    // Q.1.4 Unit Test 2
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        // 1. Setup (Arrange)
        String[] testNames = {"Product A", "Product B", "Product C"};
        int[][] testSales = {
            {10, 10, 10}, 
            {20, 20, 20}, 
            {30, 30, 30}  
        };
        Product testProduct = new Product(testNames, testSales);

        // 2. Expected Result
        // Total (180) / 9 entries = 20.0
        double expectedAverage = 20.0;

        // 3. Execute (Act)
        double actualAverage = testProduct.GetAverageProductSold();

        // 4. Verify (Assert)
        // Notice the extra '0.001' at the end. This is called a "delta". 
        // Because computers can sometimes round double (decimal) numbers slightly wrong, 
        // we allow a tiny margin of error (0.001) when comparing them.
        assertEquals(expectedAverage, actualAverage, 0.001, "The average should be 20.0");
    }

    // I added a third test just to be safe and ensure the "Most Popular" logic works
    @Test
    public void GetMostPopularProduct_WithValidData_ReturnsCorrectProduct() {
        // Setup
        String[] testNames = {"Product A", "Product B", "Product C"};
        int[][] testSales = {
            {10, 10, 10}, 
            {20, 20, 20}, 
            {30, 30, 30}  // Product C is clearly the highest
        };
        Product testProduct = new Product(testNames, testSales);

        // Expected (Product C has 90 total)
        String expectedPopular = "Product C(90)";

        // Execute
        String actualPopular = testProduct.GetMostPopularProduct();

        // Verify
        assertEquals(expectedPopular, actualPopular, "Product C should be the most popular");
    }
}
