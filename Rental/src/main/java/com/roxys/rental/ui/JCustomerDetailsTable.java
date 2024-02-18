package com.roxys.rental.ui;
import com.roxys.rental.model.CustomerDetails;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.util.List;
public class JCustomerDetailsTable {
    JFrame jFrame;
    JTable jTable;
    JPanel jPanel;
    JButton jButton;
    CustomerDetails customerDetails;
    Connection connection;
    public JCustomerDetailsTable(List<CustomerDetails> customerDetails)
    {
        jFrame = new JFrame("Customer Details");
        jPanel = new JPanel();
        jFrame.setLayout(new BorderLayout());

        String[][] data = new String[customerDetails.size()+1][6];
        int i = 0;
        for(CustomerDetails customerDetails1: customerDetails){
            String[] customerDetTable = new String[7];
            customerDetTable[0] = String.valueOf(customerDetails1.getId());
            customerDetTable[1] = customerDetails1.getFirstName();
            customerDetTable[2] = customerDetails1.getLastName();
            customerDetTable[3] = String.valueOf(customerDetails1.getDateOfBirth());
            customerDetTable[4] = customerDetails1.getAdress();
            customerDetTable[5] = customerDetails1.getCity();
            data[i] = customerDetTable;
            i++;
        }
        String[] columnNames = { "ID","First name", "Last name","Date of birth","Adress","City"};
        DefaultTableModel model = new DefaultTableModel(data,columnNames);
        jTable = new JTable(model);
        jTable.setBounds(30, 40, 200, 300);

        JScrollPane sp = new JScrollPane(jTable);
        jPanel.add(sp, BorderLayout.CENTER);

        JPanel allowedOperations = new JPanel(new GridLayout(2, 2));
        jButton = new JButton("Update");
        jButton.setBackground(Color.BLUE);
        allowedOperations.add(jButton);
        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.add(allowedOperations, BorderLayout.SOUTH);

        jFrame.getContentPane().add(jPanel);
        jFrame.pack();
        jFrame.add(sp);
        jFrame.setSize(500, 200);
        jFrame.setVisible(true);
        jButton.setVisible(true);
    }
}
