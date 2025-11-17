package br.ifsp.edu.prw3.mechanics.dto.conserto;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDTO(
        @NotBlank
        String nome,
        int experiencia

) {
}
