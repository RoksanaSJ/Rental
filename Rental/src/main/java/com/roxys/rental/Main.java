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
    }
}