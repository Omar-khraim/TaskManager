insert into users (status ,created,  updated, email, first_name, last_name, password)
values (1,current_timestamp, current_timestamp,'forTestEmail1','Test', 'testing',    '123456');
insert into users (status ,created,  updated, email, first_name, last_name, password)
values (1,current_timestamp, current_timestamp,'forTestEmail2','Test', 'testing',    '123456');
insert into users (status ,created,  updated, email, first_name, last_name, password)
values (1,current_timestamp, current_timestamp,'forTestEmail','Test', 'testing',    '123456');

insert into project (end_date, start_date, manager_id, description, name)
values (current_date, current_date, 1 , 'Hola Amigus' , 'project one');
insert into project (end_date, start_date, manager_id, description, name)
values (current_date, current_date, 1 , 'Hola comostas' , 'project two');
insert into project (end_date, start_date, manager_id, description, name)
values (current_date, current_date, 2 , 'Muchas gracias' , 'project three');


insert into role (title)
values ('Admin');
insert into role (title)
values ('Employee');
insert into role (title)
values ('Manager');


insert into role_users (roles_id, users_id)
values (1,1);
insert into role_users (roles_id, users_id)
values (2,2);
insert into role_users (roles_id, users_id)
values (3,3);