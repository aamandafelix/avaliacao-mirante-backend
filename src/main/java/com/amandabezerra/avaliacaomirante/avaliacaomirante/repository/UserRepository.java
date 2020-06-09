package com.amandabezerra.avaliacaomirante.avaliacaomirante.repository;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true,
           value = "SELECT * FROM USER WHERE username = ?1")
    User findOneByUsername(String username);
}
