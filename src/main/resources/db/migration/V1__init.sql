create table if not exists students (id bigserial primary key, name varchar(255), age int);
insert into students (name, age) values ('Bob', 25), ('Jack', 24), ('John', 30);