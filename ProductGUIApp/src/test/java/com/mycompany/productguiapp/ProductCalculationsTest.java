/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.productguiapp; // ⚠️ MAKE SURE THIS MATCHES YOUR PACKAGE NAME

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductCalculationsTest {

    // Q.2.6 Unit Test 1
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        // Setup: We use a price of 100 for easy math
        ProductCalculations calc = new ProductCalculations(100.0);
        
        // Expected: 15% of 100 is 15.0
        double expectedVat = 15.0;
        
        // Execute
        double actualVat = calc.GetVat();
        
        // Assert (Verify)
        // We add '0.001' as a delta to account for tiny rounding errors that computers sometimes make with decimals
        assertEquals(expectedVat, actualVat, 0.001, "The VAT should be 15.0");
    }

    // Q.2.6 Unit Test 2
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        // Setup: Price of 100
        ProductCalculations calc = new ProductCalculations(100.0);
        
        // Expected: Price (100) + VAT (15) + Commission (5) = 120.0
        double expectedTotal = 120.0;
        
        // Execute
        double actualTotal = calc.GetTotal();
        
        // Assert (Verify)
        assertEquals(expectedTotal, actualTotal, 0.001, "The Total should be 120.0");
    }
}
