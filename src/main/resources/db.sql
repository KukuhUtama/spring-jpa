insert into roles (name) values ('USER');
insert into roles (name) values ('ADMIN');

insert into users (password, username) values ('12345', 'User');
insert into users (password, username) values ('12345', 'Admin');

insert into users_roles (user_id, role_id) values (1,1);
insert into users_roles (user_id, role_id) values (2,2);