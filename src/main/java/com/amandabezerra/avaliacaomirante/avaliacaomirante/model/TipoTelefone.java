package com.amandabezerra.avaliacaomirante.avaliacaomirante.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tipo_telefone")
public class TipoTelefone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Size(max = 100)
    private String nome;

    public TipoTelefone() {}

    public TipoTelefone(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TipoTelefone that = (TipoTelefone) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "TipoTelefone{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
