package com.roxys.rental.mapper;

import com.roxys.rental.model.CarDetails;
import com.roxys.rental.model.CustomerDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDetailsMapper {
    private static final Logger logger
            = LoggerFactory.getLogger(CarDetailsMapper.class);
    public List<CustomerDetails> map(ResultSet rs) throws SQLException {
        List<CustomerDetails> customerDetailsList = new ArrayList<CustomerDetails>();
        while (rs.next()) {
            long id = rs.getLong("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            LocalDate dateOfBirth = rs.getDate("date_of_birth").toLocalDate();
            String adress = rs.getString("adress");
            String city = rs.getString("city");
            CustomerDetails customerDetails = new CustomerDetails(id,firstName,lastName,dateOfBirth,adress,city);
            customerDetailsList.add(customerDetails);
        }
        logger.info("Mapped customer details:" + customerDetailsList);
        return customerDetailsList;
    }
}
