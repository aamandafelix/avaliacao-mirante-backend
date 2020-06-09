package com.amandabezerra.avaliacaomirante.avaliacaomirante.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 3)
    @Column(name = "ddd")
    private String ddd;

    @NotNull
    @Size(min = 8, max = 10)
    @Column(name = "numero")
    private String numero;

    @NotNull
    @ManyToOne
    private TipoTelefone tipo;

    @NotNull
    @ManyToOne
    private Pessoa pessoa;

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

    @JsonIgnore
    public Pessoa getPessoa() {
        return pessoa;
    }

    @JsonIgnore
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
        Telefone telefone = (Telefone) o;
        return Objects.equals(id, telefone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", ddd='" + ddd + '\'' +
                ", numero='" + numero + '\'' +
                ", tipo=" + tipo +
                ", dataDeCadastro=" + dataDeCadastro +
                ", loginDoOperador='" + loginDoOperador + '\'' +
                '}';
    }
}
