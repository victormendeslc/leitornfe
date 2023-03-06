package br.com.vmlc.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Serdeable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Produto {

    private Long id;

    private String descricao;
    private String quantidade;
    private String unidade;
    private String valorTotal;

    private NotaFiscal notaFiscal;
}
