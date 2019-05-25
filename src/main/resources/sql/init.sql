CREATE SCHEMA `skills_collector` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;
 create table skills (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    );