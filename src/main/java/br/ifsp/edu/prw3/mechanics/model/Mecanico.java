package br.ifsp.edu.prw3.mechanics.model;

import br.ifsp.edu.prw3.mechanics.dto.conserto.MecanicoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private  int experiencia;

    public Mecanico(MecanicoDTO dto) {
        this.nome = dto.nome();
        this.experiencia = dto.experiencia();
    }
    public void atualizar(MecanicoDTO dto){
        if(dto.nome()!=null){
            this.nome = dto.nome();
        }
        this.experiencia = dto.experiencia();

    }
}


