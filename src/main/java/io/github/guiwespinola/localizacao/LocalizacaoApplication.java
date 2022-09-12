package io.github.guiwespinola.localizacao;

import io.github.guiwespinola.localizacao.domain.entity.Cidade;
import io.github.guiwespinola.localizacao.domain.repository.CidadeRepository;
import io.github.guiwespinola.localizacao.domain.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService service;

	@Override
	public void run(String... args) throws Exception {
		var cidade = new Cidade (null, "salvador", null);
		service.filtroDinamico(cidade).forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}



}
