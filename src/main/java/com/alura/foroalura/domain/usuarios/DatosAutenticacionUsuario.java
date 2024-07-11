package com.alura.foroalura.domain.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @Email
        String email,
        @NotBlank
        String contrasena) {
}
