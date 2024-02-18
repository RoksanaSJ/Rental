package com.roxys.rental.repository;

import com.roxys.rental.mapper.CarDetailsMapper;
import com.roxys.rental.mapper.CustomerDetailsMapper;
import com.roxys.rental.model.CarDetails;
import com.roxys.rental.model.CustomerDetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class CustomerDetailsRepository {
    private Connection connection;
    public CustomerDetailsRepository(Connection connection)
    {
        this.connection = connection;
    }
    public void insert(String firstName, String lastName, LocalDate dateOfBirth, String adress, String city) throws SQLException {
        insertDeleteUpdateStatement("INSERT INTO customer_details(first_name,last_name,date_of_birth,adress,city)"
                + " VALUES('"+firstName+"','"+lastName+"','"+dateOfBirth+"','"+adress+"','"+city+"');");
    }
    public List<CustomerDetails> findAll() throws SQLException {
        return find("SELECT * FROM customer_details ORDER BY id;");
    }
    public List<CustomerDetails> findAllByLastName(String lastName) throws SQLException {
        return find("SELECT * FROM customer_details WHERE last_name='"+lastName+"';");
    }
    private List<CustomerDetails> find(String sqlQuery) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet resultSet = stmt.executeQuery(sqlQuery)) {
                CustomerDetailsMapper customerDetailsMapper = new CustomerDetailsMapper();
                return customerDetailsMapper.map(resultSet);
            }
        }
    }
    public void delete(CustomerDetails customerDetails) throws SQLException{
        insertDeleteUpdateStatement("DELETE FROM customer_details " +
                "WHERE id=" + customerDetails.getId() +";");
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
