SELECT User, Host FROM mysql.user;
create database springTutorials;
use springTutorials;

create table User(
	user_id int primary key auto_increment,
    username varchar(255) ,
    email varchar(255),
    password varchar(255) ,
    role enum('admin', 'employee') not null
);
insert into user(user_id, username, email, password, role) values (1, "dinh", "dinh11@gmail.com", "1234", "admin");

create table Product(
	product_id int auto_increment primary key not null,
    product_name varchar(255),
    product_quantity int,
    product_price double    
); 
insert into product(product_id, product_name, product_quantity, product_price) values (1, "Banh Cream Oreo", 9, 170900);

create table Student( 
	student_id int primary key auto_increment not null,
    student_name varchar(50),
    student_age int
);

create table Mentor( 
	mentor_id int primary key auto_increment not null,
    mentor_name varchar(50),
    mentor_address varchar(50)
);

