#mysql:
#username:root
#password:ethereum420

#-------------------------------------------------
use prac;
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
#-------------------------------------------------
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
);
#-------------------------------------------------
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

);
#-------------------------------------------------
DROP TABLE IF EXISTS coin;
CREATE TABLE coin
(
  id 		INT NOT NULL AUTO_INCREMENT,
  name	VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
);
#-------------------------------------------------
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
);
#-------------------------------------------------

-- auto-generated definition
CREATE TABLE voucher
(
  id         INT AUTO_INCREMENT
    PRIMARY KEY,
  code       VARCHAR(32)                        NULL,
  type       VARCHAR(20)                        NULL,
  start_date DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
  end_date   DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
  user_id    INT                                NULL,
  limits     INT DEFAULT '1'                    NOT NULL,
  status     VARCHAR(10) DEFAULT 'VALID'        NULL,
  CONSTRAINT voucher_id_uindex
  UNIQUE (id),
  CONSTRAINT voucher_code_uindex
  UNIQUE (code)
)
  ENGINE = InnoDB;


#-------------------------------------------------
CREATE TABLE exchange
(
  id            INT AUTO_INCREMENT
    PRIMARY KEY,
  origin_type   VARCHAR(20)                        NOT NULL,
  dest_type     VARCHAR(20)                        NOT NULL,
  origin_amount DOUBLE DEFAULT '0'                 NULL,
  dest_amount   DOUBLE DEFAULT '0'                 NOT NULL,
  origin_price  DOUBLE DEFAULT '0'                 NOT NULL,
  dest_price    DOUBLE DEFAULT '0'                 NOT NULL,
  user_id       INT                                NOT NULL,
  create_time   DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  CONSTRAINT exchange_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

#-------------------------------------------------
CREATE TABLE transfer
(
  id             INT AUTO_INCREMENT
    PRIMARY KEY,
  origin_user_id INT                                NOT NULL,
  dest_user_id   INT                                NOT NULL,
  crypton_type   VARCHAR(20)                        NULL,
  crypton_amount DOUBLE                             NULL,
  crypton_price  DOUBLE                             NULL,
  create_time    DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
  CONSTRAINT transfer_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

#-------------------------------------------------
CREATE TABLE admin
(
  id       INT AUTO_INCREMENT
    PRIMARY KEY,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  CONSTRAINT admin_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;


