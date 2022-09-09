package io.github.guiwespinola.localizacao.domain.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tb_cidade")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Cidade {

    @Id
    @Column(name = "id_cidade")
    private long id;

    @Column(name = "nome", length = 85)
    @NotNull
    private String nome;

    @Column(name = "qtd_habitantes")
    @NotNull
    private Long habitantes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
