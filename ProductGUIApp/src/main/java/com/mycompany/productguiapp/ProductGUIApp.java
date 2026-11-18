/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productguiapp;

/**
 *
 * @author thape
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// The class name is now ProductGuiApp and it extends JFrame (makes it a window)
public class ProductGUIApp extends JFrame {

    // Declare GUI components
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProducts;
    private JTextField txtPrice;
    private JButton btnProcess;

    // Constructor to set up the window
    public ProductGUIApp() {
        setTitle("Product App");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen
        setLayout(new BorderLayout());

        // --- Q.2.4: MENU BAR SETUP ---
        JMenuBar menuBar = new JMenuBar();
        
        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        // Tools Menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // --- Q.2.2: FORM SETUP ---
        // Use a Grid Layout (4 rows, 2 columns) with gaps
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        formPanel.add(txtCustomerName);

        formPanel.add(new JLabel("Select Product:"));
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProducts = new JComboBox<>(products);
        formPanel.add(cmbProducts);

        formPanel.add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        formPanel.add(txtPrice);

        formPanel.add(new JLabel("")); // Empty label for spacing
        btnProcess = new JButton("PROCESS");
        formPanel.add(btnProcess);

        add(formPanel, BorderLayout.CENTER);

        // --- ACTION LISTENERS (Button Clicks) ---

        // 1. Process Button
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processData();
            }
        });

        // 2. Tools -> Process
        processItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processData();
            }
        });

        // 3. Tools -> Clear
        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCustomerName.setText("");
                txtPrice.setText("");
                cmbProducts.setSelectedIndex(0);
            }
        });

        // 4. File -> Exit
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Closes the app
            }
        });
    }

    // Q.2.3: The logic that runs when you click Process
    private void processData() {
        try {
            String customerName = txtCustomerName.getText();
            String selectedProduct = (String) cmbProducts.getSelectedItem();
            
            // Convert the text input to a number
            double price = Double.parseDouble(txtPrice.getText());

            // Use the Calculation class to get the values
            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Format the message for the pop-up
            String message = "Customer Name: " + customerName + "\n"
                           + "Product: " + selectedProduct + "\n"
                           + "VAT: R " + vat + "\n"
                           + "COMMISSION: R " + commission + "\n"
                           + "TOTAL: R " + total;

            // Show Pop-up
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to file
            saveToFile(customerName, selectedProduct, vat, commission, total);

        } catch (NumberFormatException ex) {
            // If the user types letters instead of numbers in the price box
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the price.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Helper method to save the record
    private void saveToFile(String customerName, String product, double vat, double comm, double total) {
        // The 'true' parameter means "append" (add to the end of the file, don't overwrite)
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
            
            writer.println("DATA LOG");
            writer.println("**************************");
            writer.println("Customer Name: " + customerName);
            writer.println("Product: " + product);
            writer.println("VAT: R " + vat);
            writer.println("COMMISSION: R " + comm);
            writer.println("TOTAL: R " + total);
            writer.println("**************************");
            writer.println(); // Empty line for the next entry
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data to file.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ⚠️ THIS IS THE MAIN METHOD (The entry point of the program)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create an instance of our GUI and make it visible
                new ProductGUIApp().setVisible(true); 
            }
        });
    }
}

