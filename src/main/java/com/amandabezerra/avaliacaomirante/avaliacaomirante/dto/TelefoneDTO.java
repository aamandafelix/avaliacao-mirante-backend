package com.amandabezerra.avaliacaomirante.avaliacaomirante.dto;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.TipoTelefone;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TelefoneDTO {

    private Long id;

    @NotBlank
    @Size(max = 3)
    private String ddd;

    @NotBlank
    @Size(min = 8, max = 10)
    private String numero;

    @NotBlank
    private TipoTelefone tipo;

    @NotBlank
    private Long pessoaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public String toString() {
        return "TelefoneDTO{" +
                "id=" + id +
                ", ddd='" + ddd + '\'' +
                ", numero='" + numero + '\'' +
                ", tipo=" + tipo +
                ", pessoaId=" + pessoaId +
                '}';
    }
}
