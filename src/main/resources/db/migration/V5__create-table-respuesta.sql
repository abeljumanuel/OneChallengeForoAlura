CREATE TABLE respuesta(
    id serial primary key,
    mensaje TEXT not null,
    topico_id INTEGER REFERENCES topico(id),
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    autor_id INTEGER REFERENCES usuario(id),
    solucion BOOLEAN DEFAULT FALSE
);

ALTER TABLE usuario
ADD COLUMN perfil_id INTEGER REFERENCES perfil(id)