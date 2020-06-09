package com.amandabezerra.avaliacaomirante.avaliacaomirante.service;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.dto.OperadorDTO;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.Operador;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.Perfil;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.User;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.repository.OperadorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class OperadorService {

    private final OperadorRepository operadorRepository;
    private final UserService userService;
    private final PerfilService perfilService;

    public OperadorService(OperadorRepository operadorRepository,
                           UserService userService,
                           PerfilService perfilService) {
        this.operadorRepository = operadorRepository;
        this.userService = userService;
        this.perfilService = perfilService;

    }

    public List<Operador> index() {
        return operadorRepository.findAll();
    }

    public Optional<Operador> show(Long operadorId) {
        return operadorRepository.findById(operadorId);
    }

    public Operador create(OperadorDTO operadorDTO) throws Exception {
        Set<Perfil> perfis = new HashSet<>();
        perfis.add(perfilService.show(operadorDTO.getPerfil()));
        User user = userService.create(new User(operadorDTO.getUsername(), operadorDTO.getPassword(), perfis));

        Operador operador = new Operador();
        operador.setNome(operadorDTO.getNome());
        operador.setUser(user);
        return operadorRepository.save(operador);
    }

    public Operador edit(OperadorDTO operadorDTO) {
        Operador operador = operadorRepository.findById(operadorDTO.getId()).get();
        operador.setNome(operadorDTO.getNome());

        Set<Perfil> perfis = new HashSet<>();
        perfis.add(perfilService.show(operadorDTO.getPerfil()));
        User user = userService.findOneByUsername(operadorDTO.getUsername());
        user.setPerfis(perfis);
        userService.edit(user);

        return operadorRepository.save(operador);
    }

    public void delete(Long operadorId) {
        operadorRepository.deleteById(operadorId);
    }
}
