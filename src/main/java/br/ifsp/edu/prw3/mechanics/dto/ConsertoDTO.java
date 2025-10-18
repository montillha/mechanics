package br.ifsp.edu.prw3.mechanics.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

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
