CREATE TABLE car_details (
id SERIAL PRIMARY KEY,
brand VARCHAR(255) NOT NULL,
model VARCHAR(255) NOT NULL,
type VARCHAR(255) NOT NULL,
registration_number VARCHAR(255) UNIQUE NOT NULL,
gearbox_type VARCHAR(255) NOT NULL,
fuel_type VARCHAR(255) NOT NULL
);

CREATE TABLE customer_details (
id SERIAL PRIMARY KEY,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
date_of_birth DATE NOT NULL,
adress VARCHAR(255) NOT NULL,
city VARCHAR (255) NOT NULL
);

CREATE TABLE customer_account_details (
id SERIAL PRIMARY KEY,
login VARCHAR(255) NOT NULL,
mail VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
customer_details_id INT NOT NULL,
CONSTRAINT fk_customer_details_id
 FOREIGN KEY(customer_details_id)
 REFERENCES customer_details(id)
 ON DELETE CASCADE
);