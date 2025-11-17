package br.ifsp.edu.prw3.mechanics.dto.conserto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConsertoDTO(


        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String entrada,

        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String saida,

        Boolean ativo,

        @NotNull
        @Valid
        MecanicoDTO mecanico,

        @NotNull
        @Valid
        VeiculoDTO veiculo){
}
