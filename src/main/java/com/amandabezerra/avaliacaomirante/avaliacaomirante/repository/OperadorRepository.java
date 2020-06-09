package com.amandabezerra.avaliacaomirante.avaliacaomirante.repository;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OperadorRepository extends JpaRepository<Operador, Long> {

}
