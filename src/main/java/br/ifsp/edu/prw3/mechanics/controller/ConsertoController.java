package br.ifsp.edu.prw3.mechanics.controller;

import br.ifsp.edu.prw3.mechanics.dto.AtualizarConsertoDTO;
import br.ifsp.edu.prw3.mechanics.dto.ConsertoDTO;
import br.ifsp.edu.prw3.mechanics.dto.ConsertoDadosPrincipaisDTO;
import br.ifsp.edu.prw3.mechanics.dto.ConsertoDetalhadoDTO;
import br.ifsp.edu.prw3.mechanics.model.Conserto;
import br.ifsp.edu.prw3.mechanics.repository.ConsertoRepository;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository consertoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody  @Valid ConsertoDTO consertoDTO, UriComponentsBuilder uriBuilder){
        Conserto conserto = new Conserto(consertoDTO);
        consertoRepository.save(conserto);
        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ConsertoDetalhadoDTO(conserto));
    }

    @GetMapping
    public  ResponseEntity  listar(Pageable paginacao){

        return ResponseEntity.ok( consertoRepository.findAll(paginacao));
    }

    @GetMapping("dadosPrincipais")
    public ResponseEntity listarDadosPrincipais(){
        return ResponseEntity.ok(
                consertoRepository.findAllByAtivoTrue().stream().map(ConsertoDadosPrincipaisDTO::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id){
        Optional<Conserto> optionalConserto = consertoRepository.findById(id);
        if(optionalConserto.isPresent()){
            Conserto conserto = optionalConserto.get();
            return ResponseEntity.ok(new ConsertoDetalhadoDTO(conserto));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar( @PathVariable Long id, @RequestBody @Valid AtualizarConsertoDTO dto){
        Conserto conserto = consertoRepository.getReferenceById(id);
        conserto.atualizar(dto);
        return ResponseEntity.ok(new ConsertoDetalhadoDTO(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = consertoRepository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }
}