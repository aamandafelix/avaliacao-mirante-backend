package com.amandabezerra.avaliacaomirante.avaliacaomirante.repository;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.TipoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TipoPessoaRepository extends JpaRepository<TipoPessoa, Long> {

    Optional<TipoPessoa> findByNome(String nome);
}
