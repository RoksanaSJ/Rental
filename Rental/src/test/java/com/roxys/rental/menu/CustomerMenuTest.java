package com.roxys.rental.menu;

import com.roxys.rental.connection.DatabaseConnection;
import com.roxys.rental.menu.CustomerMenu;
import com.roxys.rental.model.CustomerDetails;
import com.roxys.rental.repository.CustomerDetailsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerMenuTest {
    @Test
    public void testCustomerEmptyList(){
        CustomerMenu customerMenu = new CustomerMenu();
        List<CustomerDetails> customers =customerMenu.listCustomers();
        assertEquals(0,customers.size());
    }
    @Test
    public void testCustomerList(){
        CustomerMenu customerMenu = new CustomerMenu();
        LocalDate dateOfBirth = LocalDate.of(2020, 1, 8);
        customerMenu.addCustomer("a","a",dateOfBirth,"bb 2","bbb");
        customerMenu.addCustomer("b","b",dateOfBirth,"aa 2","aaa");
        List<CustomerDetails> customers =customerMenu.listCustomers();
        assertEquals(2,customers.size());
    }
    @Test
    public void testAddCustomer(){
        CustomerMenu customerMenu = new CustomerMenu();
        List<CustomerDetails> customersBefore = customerMenu.listCustomers();
        LocalDate dateOfBirth = LocalDate.of(2020, 1, 8);
        customerMenu.addCustomer("a","a",dateOfBirth,"bb 2","bbb");

        List<CustomerDetails> customersAfter = customerMenu.listCustomers();

        assertEquals(customersBefore.size() + 1, customersAfter.size());
    }

    @Test
    public void testDeleteCustomer(){
        CustomerMenu customerMenu = new CustomerMenu();
        LocalDate dateOfBirth = LocalDate.of(2020, 1, 8);
        customerMenu.addCustomer("q","q",dateOfBirth,"qq 2","qqq");

        CustomerDetails customerFound = customerMenu.findCustomerByFullname("q q");
        assertNotNull(customerFound);

        customerMenu.deleteCustomer(customerFound.getId());

        CustomerDetails customerFoundAfterDelete = customerMenu.findCustomerByFullname("q q");
        assertNull(customerFoundAfterDelete);
    }
    @AfterEach
    public void cleanUp() throws SQLException {
        CustomerDetailsRepository customerDetailsRepository = new CustomerDetailsRepository(DatabaseConnection.createConnection());
        customerDetailsRepository.deleteAll();
    }
}
