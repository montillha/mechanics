package br.ifsp.edu.prw3.mechanics.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MecanicoDTO(
        @NotBlank
        String nome,
        int experiencia

) {
}
