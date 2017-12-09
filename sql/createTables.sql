

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
DROP TABLE IF EXISTS wallet;
CREATE TABLE wallet 
(
  id 			INT NOT NULL AUTO_INCREMENT,
  coin_name VARCHAR(255) NOT NULL,
  address 	VARCHAR(255) NOT NULL,
  user_id 	INT NOT NULL,
  amount 	FLOAT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (user_id)
  REFERENCES user(id)
) 
-------------------------------------------------

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





















