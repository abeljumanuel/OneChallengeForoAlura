package com.alura.foroalura.infra.security;

import lombok.Data;

@Data
public class TokenResponse {
    private String token;
    private String tipo;
    private String expiracion;
}
