create database db_sample_project_choi character set utf8;
grant all privileges on db_sample_project_choi.* to root@localhost;
flush privileges;

drop table IF exists db_sample_project_choi.user;
drop table IF exists db_sample_project_choi.user_diary;
drop table if exists db_sample_project_choi.user_diary_datecategory;

create table db_sample_project_choi.user (
	user_no int primary key auto_increments,
	user_id varchar(30) unique not null,
	user_password varchar(20) not null,
	user_name varchar(20) not null,
	user_gender char(1) not null,
	user_email varchar(50),
	user_birth date
);

create table db_sample_project_choi.user_diary (
	diary_no int primary key auto_increments,
	diary_title varchar(200) not null,
	diary_contents varchar(10000),
	diary_regdate date not null,
	user_no int,
	foreign key (user_no) references db_sample_project_choi.user(user_no)
);

create table db_sample_project_choi.user_diary_datecategory (
	diary_category_year int,
	diary_category_month int,
	diary_no int,
	foreign key (diary_no) references db_sample_project_choi.user_diary(diary_no)
);