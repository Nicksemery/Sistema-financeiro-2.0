# Sistema financeiro 2.0

teste de um sistema financeiro onde anota-se despesas e receitas, utilizando os métodos estudados com a DIO.

## diagrama de classe

  ``` mermaid
classDiagram
    class Pessoa {
        +String nome
        +Boolean ativo
    }

    class Endereco {
        +String logradouro
        +String numero
        +String bairro
        +String cep
        +String cidade
        +String estado
    }

    class Lancamento {
        +String descricao
        +String dataVencimento
        +Double valor
        +String tipo
    }

    class Categoria {
        +Long codigo
    }

    Pessoa --> Endereco : endereco
    Pessoa --> Lancamento
    Lancamento --> Categoria : categoria
    Lancamento --> Pessoa : pessoa

  ```
