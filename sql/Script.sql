create database orange;


use orange;

create table user_details(
-- 	id int(100) auto_increment primary key,
	first_name varchar(50),
	last_name varchar(50),
	city varchar(50),
	province varchar(50),
	postal_code varchar(50),
	phone_number varchar(50),
	email varchar(50),
	ip_address varchar(50)/*,
	email_status bool,
	phone_number_status bool*/
);