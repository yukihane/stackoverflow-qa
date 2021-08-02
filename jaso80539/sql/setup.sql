create database mydb character set utf8mb4;
use mydb;

create table students(
    id bigint primary key,
    name varchar(10) unique not null
);

create table lectures(
    id bigint primary key,
    name varchar(10),
    finish_time datetime not null
);

create table attend_logs(
    id bigint primary key,
    student_id bigint not null,
    lecture_id bigint not null,
    attend_status varchar(255) not null,
    foreign key idx_student(student_id) references students(id),
    foreign key idx_lecture(lecture_id) references lectures(id)
);

insert into students(id, name) values
(1, 'alice'), (2, 'bob');

insert into lectures(id, name, finish_time) values
(1, 'lec-0501', '2021/05/01'), (2, 'lec-0515', '2021/05/15'), (3, 'lec-0530', '2021/05/30'), (4, 'lec-0620', '2021/06/20');

insert into attend_logs(id, student_id, lecture_id, attend_status) values
(1, 1, 1, 'late'), (2, 1, 2, 'late'), (3, 1, 3, 'absented'), (4, 1, 4, 'late'),
(5, 2, 1, 'late'), (6, 2, 2, 'late'), (7, 2, 3, 'late'), (8, 2, 4, 'late')
;
