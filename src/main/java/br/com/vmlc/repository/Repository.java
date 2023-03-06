package br.com.vmlc.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@Slf4j
public abstract class Repository<T extends Index> implements CrudRepository<T> {

    private final String indexName;
    private final ElasticsearchClient client;

    protected Repository(ElasticsearchClient client) {
        this.indexName = getIndexName();
        this.client = client;
    }

    protected String getIndexName() {
        if (isNull(indexName)) {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            return ((Class<T>) Arrays.stream(type.getActualTypeArguments()).findFirst().orElseThrow()).getSimpleName().toLowerCase();
        }
        return indexName;
    }

    @Override
    public T save(T entity) {
        try {
            UUID id = UUID.randomUUID();
            IndexResponse response = client.index(i -> i
                    .index(getIndexName())
                    .id(id.toString())
                    .document(entity)
            );

            entity.setId(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }

    @Override
    public List<T> save(List<T> entities) {
        return null;
    }

    @Override
    public T findById(UUID id) {
        return null;
    }

    @Override
    public T find(T entity) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public List<T> update(List<T> entities) {
        return null;
    }


}
