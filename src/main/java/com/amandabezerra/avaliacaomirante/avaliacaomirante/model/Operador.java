package com.amandabezerra.avaliacaomirante.avaliacaomirante.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "operador")
public class Operador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "data_de_cadastro")
    private Date dataDeCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getUsername() {
        if (this.user != null) {
            return this.user.getUsername();
        }
        return null;
    }

    public List<String> getPerfil() {
        if (this.user != null) {
            List<String> perfis = new ArrayList<>();
            this.user.getPerfis().forEach(perfil -> {
                perfis.add(perfil.getNome());
            });
            return perfis;
        }
        return null;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    @JsonIgnore
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operador operador = (Operador) o;
        return Objects.equals(id, operador.id) &&
                Objects.equals(nome, operador.nome) &&
                Objects.equals(dataDeCadastro, operador.dataDeCadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataDeCadastro);
    }

    @Override
    public String toString() {
        return "Operador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", user=" + user +
                ", dataDeCadastro=" + dataDeCadastro +
                '}';
    }
}
