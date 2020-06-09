package com.amandabezerra.avaliacaomirante.avaliacaomirante.repository;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}