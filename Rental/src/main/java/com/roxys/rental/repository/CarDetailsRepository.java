package com.roxys.rental.repository;

import com.roxys.rental.mapper.CarDetailsMapper;
import com.roxys.rental.model.CarDetails;

import java.sql.*;
import java.util.List;

public class CarDetailsRepository {
    private Connection connection;
    public CarDetailsRepository(Connection connection)
    {
        this.connection = connection;
    }
    public void insert(String brand, String model, String type, String registrationNumber, String gearboxType, String fuelType) throws SQLException {
        insertDeleteUpdateStatement("INSERT INTO car_details(brand,model,type,registration_number,gearbox_type,fuel_type)"
                + " VALUES('"+brand+"','"+model+"','"+type+"','"+registrationNumber+"','"+gearboxType+"','"+fuelType+"');");
    }
    public List<CarDetails> findAll() throws SQLException {
       return find("SELECT * FROM car_details ORDER BY id;");
    }
    public List<CarDetails> findAllByBrand(String brand) throws SQLException {
        return find("SELECT * FROM car_details WHERE brand='"+brand+"';");
    }
    private List<CarDetails> find(String sqlQuery) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet resultSet = stmt.executeQuery(sqlQuery)) {
                CarDetailsMapper carDetailsMapper = new CarDetailsMapper();
                return carDetailsMapper.map(resultSet);
            }
        }
    }
    public void delete(CarDetails carDetails) throws SQLException{
        insertDeleteUpdateStatement("DELETE FROM car_details " +
                    "WHERE id=" + carDetails.getId() +";");
    }
    public void update(CarDetails carDetails) throws SQLException {
        insertDeleteUpdateStatement("UPDATE car_details SET type='"+carDetails.getType()+"' WHERE id='"+carDetails.getId()+"';");
    }
    private void insertDeleteUpdateStatement(String sql) throws SQLException{
        try(Statement stmt = connection.createStatement()){
            stmt.executeUpdate(sql);
        }
    }
}
