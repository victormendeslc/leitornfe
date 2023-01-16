package br.com.vmlc.repository;

import br.com.vmlc.model.NotaFiscal;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface NotaFiscalRepository extends CrudRepository<NotaFiscal, Long> {
}