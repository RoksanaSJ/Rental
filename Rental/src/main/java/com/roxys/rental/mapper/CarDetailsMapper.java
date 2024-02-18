package com.roxys.rental.mapper;

import com.roxys.rental.Main;
import com.roxys.rental.model.CarDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDetailsMapper {
    private static final Logger logger
            = LoggerFactory.getLogger(CarDetailsMapper.class);
    public List<CarDetails> map(ResultSet rs) throws SQLException {
        List<CarDetails> carDetailsList = new ArrayList<CarDetails>();
        while (rs.next()) {
            long id = rs.getLong("id");
            String brand = rs.getString("brand");
            String model = rs.getString("model");
            String type = rs.getString("type");
            String registrationNumber = rs.getString("registration_number");
            String gearboxType = rs.getString("gearbox_type");
            String fuelType = rs.getString("fuel_type");
            CarDetails carDetails = new CarDetails(id,brand,model,type,registrationNumber,gearboxType,fuelType);
            carDetailsList.add(carDetails);
        }
        logger.info("Mapped car details:" + carDetailsList);
        return carDetailsList;
    }
}
