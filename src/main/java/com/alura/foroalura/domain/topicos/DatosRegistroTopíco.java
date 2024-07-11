package com.alura.foroalura.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record DatosRegistroTopíco(
        @NotBlank(message = "Es obligatorio definir un id de Usuario")
        String idUsuario,
        @Positive(message = "Defina un id de Curso")
        long idCurso,
        @NotBlank(message = "Asigne un titulo al Topico")
        String titulo,
        @NotBlank(message = "Escriba un mensaje en el Topico")
        String mensaje
) {
}
