package br.com.vmlc.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Serdeable
@Entity
@Table
@Getter
@Setter
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private Set<Produto> produtos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "razao_social_id")
    private RazaoSocial razaoSocial;
}
