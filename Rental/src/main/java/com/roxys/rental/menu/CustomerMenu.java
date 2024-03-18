package com.roxys.rental.menu;

import com.roxys.rental.connection.DatabaseConnection;
import com.roxys.rental.model.CustomerDetails;
import com.roxys.rental.repository.CustomerDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    private static final Logger logger
            = LoggerFactory.getLogger(CarMenu.class);
    public void print(){
        System.out.println("1.Add customer");
        System.out.println("2.Delete customer");
        System.out.println("3.List all customers");
        System.out.println("Enter an option: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch(option){
            case 1:
                System.out.println("Enter name:");
                String name = scanner.next().toString();
                System.out.println("Enter last name:");
                String lastName = scanner.next().toString();
                System.out.println("Enter date of birth (yyyy-MM-dd):");
                String dateOfBirth = scanner.next();
                LocalDate convertedDateOfBirth = convertToLocalDate(dateOfBirth);
                System.out.println("Enter the adress:");
                String adress = scanner.next().toString();
                System.out.println("Enter the city:");
                String city = scanner.next().toString();
                addCustomer(name,lastName,convertedDateOfBirth,adress,city);
                break;
            case 2:
                System.out.println("Enter id of the customer:");
                long id = scanner.nextInt();
                deleteCustomer(id);
                break;
            case 3:
                listCustomers();
                break;
        }
    }
    public void addCustomer(String firstName, String lastName, LocalDate dateOfBirth, String adress, String city){
        try (Connection con = DatabaseConnection.createConnection()) {
            CustomerDetailsRepository customerDetailsRepository = new CustomerDetailsRepository(con);
            customerDetailsRepository.insert(firstName,lastName,dateOfBirth,adress,city);
        } catch (SQLException e) {
            logger.error("Connection failed: " + e.getMessage());
        }
    }
    public void deleteCustomer(long id){
        try (Connection con = DatabaseConnection.createConnection()) {
            CustomerDetailsRepository customerDetailsRepository = new CustomerDetailsRepository(con);
            List<CustomerDetails> customerDetailsList = customerDetailsRepository.findAll();
            for(CustomerDetails customer : customerDetailsList){
                if(customer.getId() == id){
                    customerDetailsRepository.delete(customer);
                }
            }
        } catch (SQLException e) {
            logger.error("Connection failed: " + e.getMessage());
        }
    }
    public List<CustomerDetails> listCustomers(){
        try (Connection con = DatabaseConnection.createConnection()) {
            CustomerDetailsRepository customerDetailsRepository = new CustomerDetailsRepository(con);
            List<CustomerDetails> customerDetailsList = customerDetailsRepository.findAll();
            System.out.println(customerDetailsList);
            return customerDetailsList;
        } catch (SQLException e) {
            logger.error("Connection failed: " + e.getMessage());
        }
        return List.of();
    }

    public CustomerDetails findCustomerByFullname(String fullName){
        try (Connection con = DatabaseConnection.createConnection()) {
            CustomerDetailsRepository customerDetailsRepository = new CustomerDetailsRepository(con);
            List<CustomerDetails> customerDetailsList = customerDetailsRepository.findAll();
            for (CustomerDetails customers:customerDetailsList) {
                if((customers.getFirstName()+" "+customers.getLastName()).equals(fullName)){
                    return customers;
                }
            }
        } catch (SQLException e) {
            logger.error("Connection failed: " + e.getMessage());
        }
        return null;
    }

    private LocalDate convertToLocalDate(String date){
        try (Scanner scanner = new Scanner(date)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, formatter);
        }
    }
}
