package com.amandabezerra.avaliacaomirante.avaliacaomirante.repository;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.TipoTelefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TipoTelefoneRepository extends JpaRepository<TipoTelefone, Long> {

    Optional<TipoTelefone> findByNome(String nome);
}
