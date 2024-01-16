create database student_crud;

use student_crud;

create table student
(
    id bigint auto_increment primary key,
    name varchar(100),
    age int,
    sex bit default (1)
);