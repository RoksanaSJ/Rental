package com.roxys.rental.menu;

import com.roxys.rental.connection.DatabaseConnection;
import com.roxys.rental.model.CarDetails;
import com.roxys.rental.repository.CarDetailsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarMenuTest {
        @Test
        public void testCarEmptyList() {
            CarMenu carMenu = new CarMenu();
            List<CarDetails> cars = carMenu.listCars();
            assertEquals(0, cars.size());
        }
        @Test
        public void testCarList() {
            CarMenu carMenu = new CarMenu();
            carMenu.addCar("test", "test", "test", "test", "test", "test");
            carMenu.addCar("test2", "test2", "test2", "test2", "test2", "test2");
            List<CarDetails> cars = carMenu.listCars();
            assertEquals(2, cars.size());
        }

        @Test
        public void testAddCar() {
            CarMenu carMenu = new CarMenu();
            List<CarDetails> carsBefore = carMenu.listCars();
            carMenu.addCar("test", "test", "test", "test", "test", "test");
            List<CarDetails> carsAfter = carMenu.listCars();
            assertEquals(carsBefore.size() + 1, carsAfter.size());
        }

        @Test
        public void testDeleteCar() {
            CarMenu carMenu = new CarMenu();
            carMenu.addCar("test", "test", "test", "test", "test", "test");

            CarDetails carFound = carMenu.findCarByRegistrationNumber("test");
            assertNotNull(carFound);
            carMenu.deleteCar(carFound.getId());
            CarDetails carFoundAfterDelete = carMenu.findCarByRegistrationNumber("test");
            assertNull(carFoundAfterDelete);
        }

        @AfterEach
        public void cleanUp() throws SQLException {
            CarDetailsRepository carDetailsRepository = new CarDetailsRepository(DatabaseConnection.createConnection());
            carDetailsRepository.deleteAll();
        }
}
