package com.roxys.rental;

import com.roxys.rental.menu.CarMenu;
import com.roxys.rental.menu.CustomerMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger
            = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        CarMenu carMenu = new CarMenu();
        CustomerMenu customerMenu = new CustomerMenu();
        carMenu.print();
        customerMenu.print();

//        try (Connection con =
//                     DriverManager.getConnection("jdbc:postgresql://localhost:5432/roxys", "roxys", "roxys")) {
//            CarDetailsRepository carDetailsRepository = new CarDetailsRepository(con);
//            CustomerDetailsRepository customerDetailsRepository = new CustomerDetailsRepository(con);
//
//            List<CarDetails> carDetails= carDetailsRepository.findAll();
//            logger.info("Car details: " + carDetailsRepository.findAll());
//            logger.info("Connection created");
//            logger.info("Car details by model: "+carDetailsRepository.findAllByBrand("citroen"));
//            carDetailsRepository.delete(carDetails.get(0));
//            //carDetailsRepository.insert("fiat","linea","sedan","KPR12345","manual","gas");
//            CarDetails firstCar = carDetails.get(0);
//            firstCar.setType("A");
//            carDetailsRepository.update(firstCar);
//
//            List<CustomerDetails> customerDetails = customerDetailsRepository.findAll();
//            logger.info("Customer details: " + customerDetailsRepository.findAll());
//            logger.info(("All customers with Sik last name" + customerDetailsRepository.findAllByLastName("Sik")));
//            LocalDate dateOfBirth = LocalDate.of(2017,1,1);
//            customerDetailsRepository.insert("Fibka","Sika",dateOfBirth,"ul.Siuraczow 22","Namyslow");
//            customerDetailsRepository.delete(customerDetails.get(0));
//        } catch (SQLException e) {
//            logger.error("Connection failed: " + e.getMessage());
//            throw new RuntimeException(e);
//        }
    }
}