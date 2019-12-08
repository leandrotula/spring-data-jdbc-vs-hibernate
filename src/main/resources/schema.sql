drop table if exists car;
drop table if exists person;

create table person (
       id serial primary key,
        last_name varchar2(255),
        name varchar2(255)
    );

create table car (
       id serial primary key,
       person integer references person(id),
        brand varchar(255)
           );