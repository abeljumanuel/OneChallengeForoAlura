CREATE TABLE usuario(
    id serial primary key,
    nombre varchar(100) not null,
    email varchar(255) not null unique,
    contrasena varchar(255) not null
);