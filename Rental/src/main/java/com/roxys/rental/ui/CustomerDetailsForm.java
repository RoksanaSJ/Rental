package com.roxys.rental.ui;

import com.roxys.rental.jSwingTools.JTableButtonMouseListener;
import com.roxys.rental.jSwingTools.JTableButtonRenderer;
import com.roxys.rental.model.CustomerDetails;
import com.roxys.rental.repository.CustomerDetailsRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDetailsForm extends JFrame{
    private CustomerDetailsRepository customerDetailsRepository;
    private List<CustomerDetails> customerDetailsList;
    private List<JButton> listEdit, listDelete;
    private JTextField searchTextField;
    private JButton buttonSearch;
    private JTable jTable;

    public CustomerDetailsForm(CustomerDetailsRepository customerDetailsRepository) throws SQLException {
        super("Customer details");
        this.customerDetailsRepository = customerDetailsRepository;
        customerDetailsList = customerDetailsRepository.findAll();
        listEdit = new ArrayList<JButton>();
        listDelete = new ArrayList<JButton>();
        JPanel mainPanel = new JPanel();
        mainPanel.setSize(this.getSize().width - 5, this.getSize().height - 20);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.setSize(this.getSize().width - 5, 20);
        panel1.add(new JLabel("Last name: "));
        searchTextField = new JTextField();
        panel1.add(searchTextField);
        buttonSearch = new JButton("Search");
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchedLastName = searchTextField.getText().trim();

            }
        });
        panel1.add(buttonSearch);
        mainPanel.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        String[][] data = new String[customerDetailsList.size()+1][6];
        int i = 0;
        for(CustomerDetails customerDetails1: customerDetailsList){
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
        String[] columnNames = { "ID","First name", "Last name","Date of birth","Adress","City","Edit","Delete"};
        DefaultTableModel model = new DefaultTableModel(data,columnNames);
        jTable = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(jTable);
        jTable.setFillsViewportHeight(false);
        scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width, 250));

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        jTable.getColumn("Edit").setCellRenderer(buttonRenderer);
        jTable.getColumn("Delete").setCellRenderer(buttonRenderer);
        jTable.addMouseListener(new JTableButtonMouseListener(jTable));
        panel2.add(scrollPane);
        mainPanel.add(panel2);
        this.add(mainPanel);
        mainPanel.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
