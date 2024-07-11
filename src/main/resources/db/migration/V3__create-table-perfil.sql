CREATE TABLE perfil(
    id serial primary key,
    nombre varchar(100) not null,
    constraint perfil_unique UNIQUE (nombre)
);