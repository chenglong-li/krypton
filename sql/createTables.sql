

mysql:
username:root
password:ethereum420

-------------------------------------------------

CREATE DATABASE prac;

CREATE TABLE user
(
    id INT NOT NULL AUTO_INCREMENT,
    fname VARCHAR(255),
    lname VARCHAR(255),
   	userName VARCHAR(50),
    password VARCHAR(255),
    email VARCHAR(255),	
    mobile VARCHAR(255),
    status VARCHAR(255),
    PRIMARY KEY(id)
);