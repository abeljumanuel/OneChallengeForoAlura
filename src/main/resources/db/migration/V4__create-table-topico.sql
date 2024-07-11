CREATE TABLE topico(
    id serial primary key,
    titulo varchar(200) not null unique,
    mensaje text not null unique,
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    autor_id INTEGER REFERENCES usuario(id),
    curso_id INTEGER REFERENCES curso(id),
    status VARCHAR(100)
);