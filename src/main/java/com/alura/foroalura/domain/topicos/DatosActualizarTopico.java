package com.alura.foroalura.domain.topicos;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull(message = "Debe definir el identificador del topico a actualizar")
        Long idTopico,
        String idUsuario,
        long idCurso,
        String titulo,
        String mensaje
) {
}
