CREATE TABLE curso(
      id serial primary key,
      nombre varchar(100) not null,
      categoria varchar(100),
      constraint curso_unique UNIQUE (nombre)
);