#create database
CREATE DATABASE cafe_users;

#use database
use cafe_users;

#show all tables
show tables;

#show data from the database
select* from users;
select* from order_product_ids;
select* from  products;
select* from orders;
select* from payments;

#delete tables
drop table users;
drop table products;
drop table orders;
drop table order_product_ids;

#delete database
drop database cafe_users;





