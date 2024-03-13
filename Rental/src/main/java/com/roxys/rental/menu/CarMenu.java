package com.roxys.rental.menu;

import com.roxys.rental.Main;
import com.roxys.rental.connection.DatabaseConnection;
import com.roxys.rental.model.CarDetails;
import com.roxys.rental.repository.CarDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CarMenu {
    private static final Logger logger
            = LoggerFactory.getLogger(CarMenu.class);
    public void print(){
        System.out.println("1.Add car");
        System.out.println("2.Delete car");
        System.out.println("3.List all cars");
        System.out.println("Enter an option: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch(option){
            case 1:
                System.out.println("Enter the brand:");
                String brand = scanner.next().toString();
                System.out.println("Enter the model:");
                String model = scanner.next().toString();
                System.out.println("Enter the type:");
                String type = scanner.next().toString();
                System.out.println("Enter the registration number:");
                String registrationNumber = scanner.next().toString();
                System.out.println("Enter the gearbox type:");
                String gearboxType = scanner.next().toString();
                System.out.println("Enter the fuel type:");
                String fuelType = scanner.next().toString();
                addCar(brand,model,type,registrationNumber,gearboxType,fuelType);
                break;
            case 2:
                System.out.println("Enter id of the car:");
                long id = scanner.nextInt();
                deleteCar(id);
                break;
            case 3:
                listCars();
                break;
        }
    }
    public void addCar(String brand, String model, String type, String registrationNumber, String gearboxType, String fuelType){
        try (Connection con = DatabaseConnection.createConnection()) {
            CarDetailsRepository carDetailsRepository = new CarDetailsRepository(con);
            carDetailsRepository.insert(brand,model,type,registrationNumber,gearboxType,fuelType);
        } catch (SQLException e) {
            logger.error("Connection failed: " + e.getMessage());
        }
    }
    public void deleteCar(long id){
        try (Connection con = DatabaseConnection.createConnection()) {
            CarDetailsRepository carDetailsRepository = new CarDetailsRepository(con);
            List<CarDetails> carDetailsList = carDetailsRepository.findAll();
            for(CarDetails car : carDetailsList){
                if(car.getId() == id){
                    carDetailsRepository.delete(car);
                }
            }
        } catch (SQLException e) {
            logger.error("Connection failed: " + e.getMessage());
        }
    }
    public void listCars(){
        try (Connection con = DatabaseConnection.createConnection()) {
            CarDetailsRepository carDetailsRepository = new CarDetailsRepository(con);
            List<CarDetails> carDetailsList = carDetailsRepository.findAll();
            System.out.println(carDetailsList);
        } catch (SQLException e) {
            logger.error("Connection failed: " + e.getMessage());
        }
    }
}
