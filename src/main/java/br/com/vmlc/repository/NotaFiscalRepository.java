package br.com.vmlc.repository;


import br.com.vmlc.model.NotaFiscal;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class NotaFiscalRepository extends Repository<NotaFiscal> {

    @Inject
    public NotaFiscalRepository(ElasticsearchClient client) {
        super(client);
    }
}