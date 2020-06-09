package com.amandabezerra.avaliacaomirante.avaliacaomirante.service;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.dto.TelefoneDTO;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.Telefone;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.repository.TelefoneRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;
    private final PessoaService pessoaService;

    public TelefoneService(TelefoneRepository telefoneRepository,
                           PessoaService pessoaService) {
        this.telefoneRepository = telefoneRepository;
        this.pessoaService = pessoaService;
    }

    public Telefone create(TelefoneDTO telefoneDTO) {
        Telefone telefone = new Telefone();
        telefone.setDdd(telefoneDTO.getDdd());
        telefone.setNumero(telefoneDTO.getNumero());
        telefone.setTipo(telefoneDTO.getTipo());
        telefone.setPessoa(pessoaService.show(telefoneDTO.getPessoaId()).get());
        return telefoneRepository.save(telefone);
    }

    public void delete(Long telefoneId) {
        telefoneRepository.deleteById(telefoneId);
    }
}
