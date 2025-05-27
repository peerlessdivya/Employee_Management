create database employeemanagementsystem;
show databases;
use employeemanagementsystem;


insert into login values('admin','12345');
select * from login;

SHOW TABLES IN employeemanagementsystem;

create table employee(name varchar(20), fname varchar(20), dob varchar(30),salary varchar(20),address varchar(100),phone varchar(20), email varchar(40),education varchar(20), designation varchar(30),aadhar varchar(25),empId varchar(15));
