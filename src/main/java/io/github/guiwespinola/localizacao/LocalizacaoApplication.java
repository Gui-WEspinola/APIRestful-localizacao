package io.github.guiwespinola.localizacao;

import io.github.guiwespinola.localizacao.domain.entity.Cidade;
import io.github.guiwespinola.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		String nomeCidade = "Salvador";
		listarCidadesPorNome(nomeCidade);
		listarCidadesPorNome("sAL%");
		listarCidadesPorHabitantes();
	}

	@Transactional
	void salvarCidade(){
		var cidade = new Cidade(1L, "João Pessoa", 10000000L);
		cidadeRepository.save(cidade);
	}

	void listarCidadesPorNome(String nome){
		cidadeRepository.findByNomeLike(nome).forEach(System.out::println);
	}

	void listarCidadesPorHabitantes(){
		cidadeRepository.findByHabitantes(4698523L).forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}


}
