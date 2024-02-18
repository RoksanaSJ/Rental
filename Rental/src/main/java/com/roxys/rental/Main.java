package com.roxys.rental;

import com.roxys.rental.mapper.CarDetailsMapper;
import com.roxys.rental.model.CarDetails;
import com.roxys.rental.model.CustomerDetails;
import com.roxys.rental.repository.CarDetailsRepository;
import com.roxys.rental.repository.CustomerDetailsRepository;
import com.roxys.rental.ui.CustomerDetailsForm;
import com.roxys.rental.ui.JCarDetailsTable;
import com.roxys.rental.ui.JCustomerDetailsTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class Main {

    private static final Logger logger
            = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("App started");
        try (Connection con =
                     DriverManager.getConnection("jdbc:postgresql://localhost:5432/roxys", "roxys", "roxys")) {
            CarDetailsRepository carDetailsRepository = new CarDetailsRepository(con);
            CustomerDetailsRepository customerDetailsRepository = new CustomerDetailsRepository(con);
//            JCarDetailsTable jCarDetailsTable = new JCarDetailsTable(carDetailsRepository.findAll());
//            JCustomerDetailsTable jCustomerDetailsTable = new JCustomerDetailsTable(customerDetailsRepository.findAll());
            CustomerDetailsForm customerDetailsForm = new CustomerDetailsForm(customerDetailsRepository);
            customerDetailsForm.setSize(600,300);
            customerDetailsForm.setVisible(true);
            customerDetailsForm.setLocation(200,10);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) {
////        logger.info("Hello world!!");
////        try (Connection con =
////                     DriverManager.getConnection("jdbc:postgresql://localhost:5432/roxys", "roxys", "roxys")) {
////            CarDetailsRepository carDetailsRepository = new CarDetailsRepository(con);
////            CustomerDetailsRepository customerDetailsRepository = new CustomerDetailsRepository(con);
////
////            List<CarDetails> carDetails= carDetailsRepository.findAll();
////            logger.info("Car details: " + carDetailsRepository.findAll());
////            logger.info("Connection created");
////            logger.info("Car details by model: "+carDetailsRepository.findAllByBrand("citroen"));
//////            carDetailsRepository.delete(carDetails.get(0));
//////            carDetailsRepository.create("fiat","linea","sedan","KPR12345","manual","gas");
////            CarDetails firstCar = carDetails.get(0);
////            firstCar.setType("A");
////            carDetailsRepository.update(firstCar);
////
////            List<CustomerDetails> customerDetails = customerDetailsRepository.findAll();
////            logger.info("Customer details: " + customerDetailsRepository.findAll());
////            logger.info(("All customers with Sik last name" + customerDetailsRepository.findAllByLastName("Sik")));
////            LocalDate dateOfBirth = LocalDate.of(2017,1,1);
////            customerDetailsRepository.insert("Fibka","Sika",dateOfBirth,"ul.Siuraczow 22","Namyslow");
//////            customerDetailsRepository.delete(customerDetails.get(0));
////        } catch (SQLException e) {
////            logger.error("Connection failed: " + e.getMessage());
////            throw new RuntimeException(e);
////        }
//    }
}