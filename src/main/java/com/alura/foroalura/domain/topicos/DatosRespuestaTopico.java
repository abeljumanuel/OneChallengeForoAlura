package com.alura.foroalura.domain.topicos;

public record DatosRespuestaTopico(
        long id,
        String titulo,
        String mensaje,
        long curso_id
) {
}
