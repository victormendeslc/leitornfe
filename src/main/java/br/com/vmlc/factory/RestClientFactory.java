package br.com.vmlc.factory;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;


@Factory
public class RestClientFactory {

    @Bean
    @Singleton
    public RestClient restClient() {
        return RestClient.builder(new HttpHost("localhost", 9200)).build();
    }


    @Bean
    @Singleton
    public ElasticsearchClient search(RestClient restClient) {
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        return new ElasticsearchClient(transport);
    }
}