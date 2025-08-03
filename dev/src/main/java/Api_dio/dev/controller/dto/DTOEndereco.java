package Api_dio.dev.controller.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DTOEndereco(@NotNull String logradouro,
                          @NotNull String bairro,
                          @NotNull @Pattern(regexp = "\\d{8}") String cep,
                          @NotNull String cidade,
                          @NotNull String estado,
                          String complemento,
                          String numero) {
}
