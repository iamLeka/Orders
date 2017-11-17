create table external_orders(
id int primary key auto_increment,
customerid int,
orderdatetime DateTime,
item varchar(100),
amount int
);