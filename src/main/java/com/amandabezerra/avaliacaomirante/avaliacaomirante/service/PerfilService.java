package com.amandabezerra.avaliacaomirante.avaliacaomirante.service;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.Perfil;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.repository.PerfilRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public List<Perfil> index() {
        return perfilRepository.findAll();
    }

    public Perfil show(String nome) {
        return perfilRepository.findByNome(nome).get();
    }
}
