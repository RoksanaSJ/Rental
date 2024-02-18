package com.roxys.rental.ui;

import com.roxys.rental.model.CarDetails;

import javax.swing.*;
import java.util.List;

public class JCarDetailsTable {
    JFrame jFrame;
    JTable jTable;
    JPanel jPanel;
    JButton jButton;
    CarDetails carDetails;
    public JCarDetailsTable(List<CarDetails> carDetails)
    {
        jFrame = new JFrame("Car Details");
        jPanel = new JPanel();

        String[][] data = new String[carDetails.size()+1][7];
        int i = 0;
        for(CarDetails carDetails1: carDetails){
            String[] carDetTable = new String[7];
            carDetTable[0] = String.valueOf(carDetails1.getId());
            carDetTable[1] = carDetails1.getBrand();
            carDetTable[2] = carDetails1.getModel();
            carDetTable[3] = carDetails1.getType();
            carDetTable[4] = carDetails1.getRegistrationNumber();
            carDetTable[5] = carDetails1.getGearboxType();
            carDetTable[6] = carDetails1.getFuelType();
            data[i] = carDetTable;
            i++;
        }

        String[] columnNames = { "ID","Brand", "Model","Type","Registration number","Gearbox type","Fuel type" };

        jTable = new JTable(data, columnNames);
        jTable.setBounds(30, 40, 200, 300);

        JScrollPane sp = new JScrollPane(jTable);
        jFrame.add(sp);
        jFrame.setSize(500, 200);
        jFrame.setVisible(true);
    }
}
