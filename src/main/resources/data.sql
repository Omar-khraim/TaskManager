insert into users (created,  updated, email, first_name, last_name, password)
values (current_timestamp, current_timestamp,'forTestEmail1','Test', 'testing',    '123456');
insert into users (created,  updated, email, first_name, last_name, password)
values (current_timestamp, current_timestamp,'forTestEmail2','Test', 'testing',    '123456');
insert into users (created,  updated, email, first_name, last_name, password)
values (current_timestamp, current_timestamp,'forTestEmail','Test', 'testing',    '123456');

insert into project (end_date, start_date, manager_id, description, name)
values (current_date, current_date, 1 , 'Hola Amigus' , 'project one');
insert into project (end_date, start_date, manager_id, description, name)
values (current_date, current_date, 1 , 'Hola comostas' , 'project two');
insert into project (end_date, start_date, manager_id, description, name)
values (current_date, current_date, 2 , 'Muchas gracias' , 'project three');