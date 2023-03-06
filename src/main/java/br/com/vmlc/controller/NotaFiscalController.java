package br.com.vmlc.controller;


import br.com.vmlc.model.NotaFiscal;
import br.com.vmlc.request.PaginaRequest;
import br.com.vmlc.service.ConectorHttp;
import br.com.vmlc.service.NotaFiscalService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;


@Validated
@Controller("/nota")
public class NotaFiscalController {

    @Inject
    private ConectorHttp conectorHttp;

    @Inject
    private NotaFiscalService service;

    @Post
    public HttpResponse<?> saveNota(@Body PaginaRequest nota) {
        NotaFiscal nf = conectorHttp.buscar(nota);
        NotaFiscal salvar = service.salvar(nf);
        return HttpResponse.status(HttpStatus.CREATED).body(salvar);
    }
}
