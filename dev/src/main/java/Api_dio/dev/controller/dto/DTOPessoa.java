package Api_dio.dev.controller.dto;

import Api_dio.dev.domain.model.Endereco;
import Api_dio.dev.domain.model.Pessoa;
import jakarta.validation.constraints.NotBlank;

public record DTOPessoa(
        Long id,
        @NotBlank String nome,
        Endereco endereco) {


    public DTOPessoa(Pessoa pessoa){
        this( pessoa.getId(), pessoa.getNome(), pessoa.getEndereco());
    }

    public Pessoa toModel() {
        Pessoa model = new Pessoa();
        model.setId(id);
        model.setNome(nome);
        model.setEndereco(endereco);
        return model;
    }
}

