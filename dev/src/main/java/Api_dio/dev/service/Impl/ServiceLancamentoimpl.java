package Api_dio.dev.service.Impl;

import Api_dio.dev.domain.model.Lancamento;
import Api_dio.dev.domain.model.Pessoa;
import Api_dio.dev.domain.repository.LancamentoRepository;
import Api_dio.dev.service.exception.BusinessException;
import Api_dio.dev.service.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class ServiceLancamentoimpl {

    private final LancamentoRepository lancamentoRepository;

    public ServiceLancamentoimpl(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    @Transactional
    public List<Lancamento> findAll() {
        return this.lancamentoRepository.findAll();
    }

    @Transactional
    public Lancamento findById(Long id) {
        return this.lancamentoRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Lancamento create(Lancamento lancamento) {
        ofNullable(lancamento).orElseThrow(() -> new BusinessException("Not be null"));
        return this.lancamentoRepository.save(lancamento);
    }

    @Transactional
    public Lancamento update(Long id, Lancamento lancamento) {
        Lancamento old = this.findById(id);
        if(!old.getId().equals(lancamento.getId())) {
            throw new BusinessException("Update IDs must be the same.");
    }

        old.setDescricao(lancamento.getDescricao());
        old.setData_pagamento(lancamento.getData_pagamento());
        old.setData_vencimento(lancamento.getData_vencimento());
        old.setTipo(lancamento.getTipo());
        return this.lancamentoRepository.save(old);

    }
    @Transactional
    public void delete(Long id) {
        Lancamento dbUser = this.findById(id);
        this.lancamentoRepository.delete(dbUser);
    }
}
