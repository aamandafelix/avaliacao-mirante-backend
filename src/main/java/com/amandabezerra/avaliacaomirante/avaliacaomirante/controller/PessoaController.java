package com.amandabezerra.avaliacaomirante.avaliacaomirante.controller;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.dto.PessoaDTO;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> index() {
        return ResponseEntity.ok(pessoaService.index());
    }

    @GetMapping(value = "/{pessoaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> show(@PathVariable(value = "pessoaId") Long pessoaId) {
        return ResponseEntity.ok(pessoaService.show(pessoaId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok(pessoaService.create(pessoaDTO));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> edit(@RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok(pessoaService.edit(pessoaDTO));
    }

    @DeleteMapping(value = "/{pessoaId}")
    public ResponseEntity<Object> delete(@PathVariable(value = "pessoaId") Long pessoaId) {
        pessoaService.delete(pessoaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
