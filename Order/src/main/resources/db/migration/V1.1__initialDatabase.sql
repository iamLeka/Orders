CREATE TABLE ITEM(
  ITEM_ID INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(20) NOT NULL,
  DESCRIPTION TEXT,
  PRICE DECIMAL(10,2)
);

CREATE TABLE STOCK(
  STOCK_ID  INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  ITEM_ID  INT(10) UNSIGNED NOT NULL,

  FOREIGN KEY (ITEM_ID) REFERENCES ITEM(ITEM_ID)
);

CREATE TABLE CUSTOMERS(
  CUSTOMER_ID INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(20) NOT NULL,
  LAST_NAME VARCHAR(20) NOT NULL
);

CREATE TABLE ORDERS(
  ORDER_ID INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  CUSTOMER_ID INT(10) UNSIGNED NOT NULL,
  ORDER_DATE DATE NOT NULL
);