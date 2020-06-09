package com.amandabezerra.avaliacaomirante.avaliacaomirante.model;

import java.util.Set;

public class AuthenticationRequest {

    private String username;

    private String password;

    private Set<Perfil> perfis;

    public AuthenticationRequest() {}

    public AuthenticationRequest(String username, String password, Set<Perfil> perfis) {
        this.username = username;
        this.password = password;
        this.perfis = perfis;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
}
