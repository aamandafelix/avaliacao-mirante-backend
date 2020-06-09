package com.amandabezerra.avaliacaomirante.avaliacaomirante.repository;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
