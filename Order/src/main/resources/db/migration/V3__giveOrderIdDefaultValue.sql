ALTER TABLE ORDERS
MODIFY ORDER_DATE datetime default current_timestamp,
MODIFY CUSTOMER_ID int(10) UNSIGNED NOT NULL default 1;