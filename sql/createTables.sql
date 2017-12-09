

mysql:
username:root
password:ethereum420

-------------------------------------------------

#CREATE DATABASE prac;
DROP TABLE IF EXISTS user;
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
DROP TABLE IF EXISTS wallet;
CREATE TABLE wallet 
(
  id 		INT NOT NULL AUTO_INCREMENT,
  coin_id	INT NOT NULL,
  address 	VARCHAR(255) NOT NULL,
  user_id 	INT NOT NULL,
  amount 	FLOAT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (coin_id)
  REFERENCES coin(id),
  FOREIGN KEY (user_id)
  REFERENCES user(id)
) 
-------------------------------------------------
DROP TABLE IF EXISTS offer;
CREATE TABLE offer 
(
  coin_name VARCHAR(255) NOT NULL,
  amount	FLOAT NOT NULL,
  price		FLOAT NOT NULL,
  source_user_id	INT NOT NULL,
  dest_user_id		INT NOT NULL,
  FOREIGN KEY (source_user_id)
  REFERENCES user(id),
  FOREIGN KEY (dest_user_id)
  REFERENCES user(id)

) 
-------------------------------------------------
DROP TABLE IF EXISTS coin;
CREATE TABLE coin 
(
	id 		INT NOT NULL AUTO_INCREMENT,
	name	VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
)
-------------------------------------------------
DROP TABLE IF EXISTS orders;
CREATE TABLE orders
(
  id 					INT NOT NULL AUTO_INCREMENT,
  user_id				INT NOT NULL,
  source_coin_id		INT NOT NULL,
  source_coin_amount	FLOAT NOT NULL,
  dest_coin_amount		FLOAT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (user_id)
  REFERENCES user(id),
  FOREIGN KEY (source_coin_id)
  REFERENCES coin(id)
) 
-------------------------------------------------



















