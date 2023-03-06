package br.com.vmlc.service;

import br.com.vmlc.model.NotaFiscal;
import br.com.vmlc.repository.NotaFiscalRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class NotaFiscalServiceImpl implements NotaFiscalService {
    @Inject
    private NotaFiscalRepository repository;

    @Override
    public NotaFiscal salvar(NotaFiscal notaFiscal) {
        return repository.save(notaFiscal);
    }
}
