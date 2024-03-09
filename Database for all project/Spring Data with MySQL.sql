create database springTutorials;
use springTutorials;

create table User(
	id int primary key auto_increment,
    username varchar(255) not null,
    email varchar(255) not null
);