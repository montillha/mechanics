package br.ifsp.edu.prw3.mechanics.model;
import br.ifsp.edu.prw3.mechanics.dto.conserto.AtualizarConsertoDTO;
import br.ifsp.edu.prw3.mechanics.dto.conserto.ConsertoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name="conserto")
@Entity(name="conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true, updatable = false)
    private final String uuid = UUID.randomUUID().toString();

    private String entrada;

    private String saida;
    private Boolean ativo;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;

    public Conserto(ConsertoDTO consertoDTO) {
        this.entrada = consertoDTO.entrada();
        this.saida = consertoDTO.saida();
        this.ativo = true;
        this.mecanico = new Mecanico(consertoDTO.mecanico()) ;
        this.veiculo =  new Veiculo(consertoDTO.veiculo());
    }

    public  void atualizar(AtualizarConsertoDTO dto){
        if(dto.saida()!=null){
            this.saida = dto.saida();
        }
        if(dto.mecanico()!=null){
            this.mecanico.atualizar(dto.mecanico());
        }


    }
    public  void excluir(){
        this.ativo = false;
    }
}

