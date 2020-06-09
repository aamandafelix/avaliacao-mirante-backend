package com.amandabezerra.avaliacaomirante.avaliacaomirante.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "documento")
    private String documento;

    @NotNull
    @NotBlank
    @Column(name = "data_de_nascimento")
    private String dataDeNascimento;

    @Size(max = 100)
    @Column(name = "nome_da_mae")
    private String nomeDaMae;

    @Size(max = 100)
    @Column(name = "nome_do_pai")
    private String nomeDoPai;

    @ManyToOne
    private TipoPessoa tipo;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Set<Telefone> telefones = new HashSet<>();

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "data_de_cadastro")
    private Date dataDeCadastro;

    @Column(name = "login_do_operador")
    private String loginDoOperador;

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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getLoginDoOperador() {
        return loginDoOperador;
    }

    public void setLoginDoOperador(String loginDoOperador) {
        this.loginDoOperador = loginDoOperador;
    }

    @PrePersist
    public void prePersist() {
        loginDoOperador = SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", dataDeNascimento='" + dataDeNascimento + '\'' +
                ", nomeDaMae='" + nomeDaMae + '\'' +
                ", nomeDoPai='" + nomeDoPai + '\'' +
                ", tipo=" + tipo +
                ", telefone=" + telefones +
                ", dataDeCadastro=" + dataDeCadastro +
                ", loginDoOperador='" + loginDoOperador + '\'' +
                '}';
    }
}
