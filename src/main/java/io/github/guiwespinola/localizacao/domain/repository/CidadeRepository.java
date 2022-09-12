package io.github.guiwespinola.localizacao.domain.repository;

import io.github.guiwespinola.localizacao.domain.entity.Cidade;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByNome(String nome);

    List<Cidade> findByNomeContaining(String nome);

    @Query(" select c from Cidade c where lower(c.nome) like lower(:nome) ")
    List<Cidade> findByNomeLike(String nome, Pageable pageable);

    List<Cidade> findByHabitantes(Long habitantes);

    List<Cidade> findByHabitantesLessThan(Long habitantes);

    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);
}
