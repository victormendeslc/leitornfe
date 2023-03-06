package br.com.vmlc.model;

import br.com.vmlc.repository.Index;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Serdeable
@Getter
@Setter
public class NotaFiscal implements Index {
    private UUID id;

    private Set<Produto> produtos = new HashSet<>();
    private RazaoSocial razaoSocial;
}
