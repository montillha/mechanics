package br.ifsp.edu.prw3.mechanics.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacaoDto(
    @NotBlank
    String login,
    @NotBlank
    String senha)
{}
