package com.amandabezerra.avaliacaomirante.avaliacaomirante.model;

public class AuthenticationResponse {

    private final String jwt;

    private String perfil = null;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public AuthenticationResponse(String jwt, String perfil) {
        this.jwt = jwt;
        this.perfil = perfil;
    }

    public String getJwt() {
        return jwt;
    }

    public String getPerfil() {
        return perfil;
    }
}
