package br.com.vmlc.repository;

import java.util.List;
import java.util.UUID;

public interface CrudRepository<T> {

    T save(T entity);

    List<T> save(List<T> entities);

    T findById(UUID id);

    T find(T entity);

    void delete(T entity);

    T update(T entity);

    List<T> update(List<T> entities);
}
