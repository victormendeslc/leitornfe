package br.com.vmlc.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Serdeable
@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RazaoSocial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cnpj;
    private String inscricaoEstadual;
    private String endereco;
    private String estado;


}
