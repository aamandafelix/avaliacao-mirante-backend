package com.amandabezerra.avaliacaomirante.avaliacaomirante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class AvaliacaoMiranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoMiranteApplication.class, args);
	}

	@RequestMapping(path = "/")
	public String hello() {
		return "Bem vindo à API do Avaliação Mirante. Feito por: https://github.com/amandabezerra/";
	}

}
