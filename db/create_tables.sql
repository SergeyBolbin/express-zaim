drop database if exists exzaim01;

create database exzaim01;

create table exzaim01.user(
	id integer not null auto_increment,
	login varchar(150) not null,
	password varchar(150) not null,
	active smallint not null default 0,
	system smallint not null default 0,
	primary key (id),
	constraint user_login_c_uq unique (login)
);

create index user_login_idx on exzaim01.user(login);
create index user_active_idx on exzaim01.user(active);

create table exzaim01.role(
	id integer not null,
	role varchar(100) not null,
	primary key (id),
	constraint role_role_c_uq unique (role)
);

create index role_role_idx on exzaim01.role(role);


--	constraint user_role_c_uq unique (user_id, role_id),
create table exzaim01.user_role(
	user_id integer not null ,
	role_id integer not null,
	PRIMARY KEY (user_id, role_id),
	FOREIGN KEY (user_id) REFERENCES exzaim01.user(id) ON DELETE CASCADE,
	FOREIGN KEY (role_id) REFERENCES exzaim01.role(id)
);

insert into exzaim01.user (login, password, active, system) values ('SystemUser', 'SystemUser', 1, 1); 
insert into exzaim01.user (login, password, active, system) values ('admin', 'admin01', 1, 0);

insert into exzaim01.role (id, role) values 
(1, 'SystemRole'),
(2, 'UsersViewer'),
(3, 'UsersEditor');

insert into exzaim01.user_role (user_id, role_id) 
select u.id, r.id 
from exzaim01.user u, exzaim01.role r
where u.login in ('SystemUser', 'admin'); 


CREATE USER 'ez_user'@'localhost' IDENTIFIED BY 'user01';
GRANT INSERT, UPDATE, DELETE, SELECT, SHOW VIEW, SHOW DATABASES ON exzaim01.* TO 'ez_user'@'localhost';