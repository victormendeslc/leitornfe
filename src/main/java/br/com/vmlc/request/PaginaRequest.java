package br.com.vmlc.request;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;


@Serdeable
@Data
public class PaginaRequest {

    private String pagina;


}
