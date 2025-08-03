package Api_dio.dev.controller.dto;

import Api_dio.dev.domain.model.Lancamento;
import Api_dio.dev.domain.model.Pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DTOLancemanto(
                            Long id,
                            String descricao,
                            LocalDate data_vencimento,
                            LocalDate data_pagamento,
                            BigDecimal valor
) {

    public DTOLancemanto(Lancamento lancamento){
        this(lancamento.getId(), lancamento.getDescricao(), lancamento.getData_vencimento(),lancamento.getData_pagamento(),lancamento.getValor());
    }

    public Lancamento toModel(){
        Lancamento model = new Lancamento();
        model.setId(id);
        model.setDescricao(descricao);
        model.setData_vencimento(data_vencimento);
        model.setData_pagamento(data_pagamento);
        model.setValor(valor);
        model.getPessoa(new Pessoa());
        return model;
    }
}
