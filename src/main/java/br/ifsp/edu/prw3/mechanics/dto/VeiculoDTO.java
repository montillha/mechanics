package br.ifsp.edu.prw3.mechanics.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(

        @NotBlank
        String modelo,

        @NotBlank
        String marca,

        @NotBlank
        @Pattern(regexp = "^\\d{4}$")
        String ano,
        String cor
) {
}
