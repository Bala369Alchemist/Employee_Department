create database employee_department

use employee_department

create table employee(employee_id int primary key auto_increment NOT NULL , employee_name varchar(30) NOT NULL , age int NOT NULL , department_id varchar(30) NOT NULL)

select * from employee
drop table employee


create table department(department_id int primary key auto_increment NOT NULL , department_name varchar(30) NOT NULL)

select * from department
drop table department