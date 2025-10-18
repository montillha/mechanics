package br.ifsp.edu.prw3.mechanics.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarConsertoDTO(
       String saida,
       MecanicoDTO mecanico
) {
}
