package br.ifsp.edu.prw3.mechanics.dto;

import br.ifsp.edu.prw3.mechanics.model.Conserto;

public record ConsertoDadosPrincipaisDTO(
        Long id,
        String entrada,
        String saida,
        String nome,
        String modelo,
        String marca) {
    public ConsertoDadosPrincipaisDTO(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getEntrada(),
                conserto.getSaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getModelo(),
                conserto.getVeiculo().getMarca()
        );
    }
}
