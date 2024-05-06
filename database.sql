CREATE DATABASE quickstart;
USE quickstart;

CREATE TABLE category (
    idCategory INT PRIMARY KEY,
    nameCategory VARCHAR(50)NOT NULL,
    descriptionCategory VARCHAR(255) NOT NULL    
);

CREATE TABLE product (
    idProduct INT PRIMARY KEY,
    nameProduct VARCHAR(50) NOT NULL,
    descriptionProduct VARCHAR(255) NOT NULL,
    stock INT NOT NULL,
    price FLOAT NOT NULL,
    idCategory INT NOT NULL,
    FOREIGN KEY (idCategory) REFERENCES category(idCategory)
);
