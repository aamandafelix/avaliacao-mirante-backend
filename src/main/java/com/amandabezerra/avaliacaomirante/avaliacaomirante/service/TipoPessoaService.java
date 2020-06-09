package com.amandabezerra.avaliacaomirante.avaliacaomirante.service;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.TipoPessoa;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.repository.TipoPessoaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TipoPessoaService {

    private final TipoPessoaRepository tipoPessoaRepository;

    public TipoPessoaService(TipoPessoaRepository tipoPessoaRepository) {
        this.tipoPessoaRepository = tipoPessoaRepository;
    }

    public List<TipoPessoa> index() {
        return tipoPessoaRepository.findAll();
    }

    public TipoPessoa show(String nome) {
        return tipoPessoaRepository.findByNome(nome).get();
    }
}
