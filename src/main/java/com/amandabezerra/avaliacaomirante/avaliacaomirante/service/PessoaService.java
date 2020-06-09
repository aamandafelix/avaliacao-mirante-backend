package com.amandabezerra.avaliacaomirante.avaliacaomirante.service;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.dto.PessoaDTO;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.Pessoa;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.TipoPessoa;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final TipoPessoaService tipoPessoaService;

    public PessoaService(PessoaRepository pessoaRepository,
                         TipoPessoaService tipoPessoaService) {
        this.pessoaRepository = pessoaRepository;
        this.tipoPessoaService = tipoPessoaService;

    }

    public List<Pessoa> index() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> show(Long pessoaId) {
        return pessoaRepository.findById(pessoaId);
    }

    public Pessoa create(PessoaDTO pessoaDTO) {
        TipoPessoa tipoPessoa = tipoPessoaService.show(pessoaDTO.getTipoPessoa());
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDocumento(pessoaDTO.getDocumento());
        pessoa.setDataDeNascimento(pessoaDTO.getDataDeNascimento());
        pessoa.setNomeDaMae(pessoaDTO.getNomeDaMae());
        pessoa.setNomeDoPai(pessoaDTO.getNomeDoPai());
        pessoa.setTipo(tipoPessoa);

        return pessoaRepository.save(pessoa);
    }

    public Pessoa edit(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findById(pessoaDTO.getId()).get();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDataDeNascimento(pessoaDTO.getDataDeNascimento());
        pessoa.setNomeDaMae(pessoaDTO.getNomeDaMae());
        pessoa.setNomeDoPai(pessoaDTO.getNomeDoPai());
        return pessoaRepository.save(pessoa);
    }

    public void delete(Long pessoaId) {
        pessoaRepository.deleteById(pessoaId);
    }
}
