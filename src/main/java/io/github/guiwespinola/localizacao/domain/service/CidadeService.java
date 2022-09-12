package io.github.guiwespinola.localizacao.domain.service;

import io.github.guiwespinola.localizacao.domain.entity.Cidade;
import io.github.guiwespinola.localizacao.domain.repository.CidadeRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {

    private final CidadeRepository repository;

    public CidadeService(CidadeRepository repository){
        this.repository = repository;
    }

    @Transactional
    public void salvarCidade(){
        var cidade = new Cidade(1L, "João Pessoa", 10000000L);
        repository.save(cidade);
    }

    public void listarCidadesPorQuantidadeHabitantes(){
        repository.findByHabitantesLessThanAndNomeLike(1000001L, "Br%").forEach(System.out::println);
    }

    public void listarCidadesPorNome(String nome){
        Pageable pageable = PageRequest.of(1,2);
        repository
                .findByNomeLike(nome, pageable)
                .forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes(){
        repository.findByHabitantes(4698523L).forEach(System.out::println);
    }

    public void listarCidadesPorNomeContendo(String nome){
        repository.findByNomeContaining(nome).forEach(System.out::println);
    }

    public void listarCidadesPorHabitantesLessThan(Long habitantes){
        repository.findByHabitantesLessThan(habitantes).forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase("nome") //nome da propriedade pra ignorar
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return repository.findAll(example);
    }
}
