package br.com.vmlc.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.*;

import javax.persistence.*;

@Serdeable
@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descricao;
    private String quantidade;
    private String unidade;
    private String valorTotal;

    @ManyToOne
    @JoinColumn(name = "nota_fiscal_id")
    private NotaFiscal notaFiscal;
}
