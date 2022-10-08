create database if not exists productivity;
 
use productivity;
 
drop table if exists goals;
create table goals (
   id int auto_increment,
   date varchar(30),
   user varchar(30),
   Goal varchar(50),
   difficulty int,
   primary key(id)
   );
   
drop table if exists reflections;   
create table reflections (
   id int auto_increment,
   date varchar(30),
   user varchar(30),
   Goal varchar(50),
   description varchar(100),
   stars int,
   difficulty int,
   primary key(id)
   );
   
drop table if exists users;
create table users (
   id int auto_increment,
   username varchar(30),
   password varchar(50),
   primary key(id)
   );

select * from goals, reflections, users;
DELETE FROM productivity;
