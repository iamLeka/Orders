ALTER TABLE ORDERS ADD FOREIGN KEY
  (CUSTOMER_ID) REFERENCES
  CUSTOMERS (CUSTOMER_ID);


CREATE TABLE ITEMS_ON_ORDER (
  IOO_ID INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  ORDER_ID INT(10) UNSIGNED NOT NULL,
  ITEM_ID INT(10) UNSIGNED NOT NULL,

  FOREIGN KEY (ORDER_ID) REFERENCES ORDERS (ORDER_ID),
  FOREIGN KEY (ITEM_ID) REFERENCES ITEMS (ITEM_ID)
)