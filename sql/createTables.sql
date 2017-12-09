

mysql:
username:root
password:ethereum420

-------------------------------------------------

CREATE DATABASE prac;

CREATE TABLE user
(
    id 			INT NOT NULL AUTO_INCREMENT,
    fname 		VARCHAR(255),
    lname 		VARCHAR(255),
   	userName 	VARCHAR(50),
    password	VARCHAR(255),
    email 		VARCHAR(255),	
    mobile 		VARCHAR(255),
    status 		VARCHAR(255),
    PRIMARY KEY(id)
);

-------------------------------------------------
CREATE TABLE coin
(
    name 			INT NOT NULL AUTO_INCREMENT,
    price 		VARCHAR(255),
    type 		VARCHAR(255),
   	userName 	VARCHAR(50),
    password	VARCHAR(255),
    email 		VARCHAR(255),	
    mobile 		VARCHAR(255),
    status 		VARCHAR(255),
    PRIMARY KEY(id)
);


CREATE TABLE wallet 
(
  address varchar(255) NOT NULL,
  user_id int(11) NOT NULL,
  amount float DEFAULT NULL,
  FOREIGN KEY (user_id)
  REFERENCES user(id)
  
) 

























