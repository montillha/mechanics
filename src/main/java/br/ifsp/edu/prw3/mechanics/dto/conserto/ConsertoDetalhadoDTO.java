package br.ifsp.edu.prw3.mechanics.dto.conserto;

import br.ifsp.edu.prw3.mechanics.model.Conserto;
import br.ifsp.edu.prw3.mechanics.model.Mecanico;
import br.ifsp.edu.prw3.mechanics.model.Veiculo;

public record ConsertoDetalhadoDTO(
        Long id,
        String entrada,
        String saida,
        Boolean ativo,
        Mecanico mecanico,
        Veiculo veiculo
) {

    public ConsertoDetalhadoDTO(Conserto conserto){
        this(conserto.getId(), conserto.getEntrada(), conserto.getSaida(), conserto.getAtivo(),
                conserto.getMecanico(),conserto.getVeiculo());
    }
}
