package com.amandabezerra.avaliacaomirante.avaliacaomirante.service;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.TipoTelefone;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.repository.TipoTelefoneRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TipoTelefoneService {


    private final TipoTelefoneRepository tipoTelefoneRepository;

    public TipoTelefoneService(TipoTelefoneRepository tipoTelefoneRepository) {
        this.tipoTelefoneRepository = tipoTelefoneRepository;
    }

    public List<TipoTelefone> index() {
        return tipoTelefoneRepository.findAll();
    }

    public TipoTelefone show(String nome) {
        return tipoTelefoneRepository.findByNome(nome).get();
    }
}
