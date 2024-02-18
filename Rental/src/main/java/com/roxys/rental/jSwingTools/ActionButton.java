package com.roxys.rental.jSwingTools;

import com.roxys.rental.model.CustomerDetails;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ActionButton extends JButton {
    private Connection connection;
    public ActionButton(Connection connection){
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3,3,3,3));
        this.connection = connection;
    }

    public void update(CustomerDetails customerDetails) throws SQLException {
        insertDeleteUpdateStatement("UPDATE customer_details SET adress='"+customerDetails.getAdress()+"' WHERE id='"+customerDetails.getId()+"';");
    }
    private void insertDeleteUpdateStatement(String sql) throws SQLException{
        try(Statement stmt = connection.createStatement()){
            stmt.executeUpdate(sql);
        }
    }
}
