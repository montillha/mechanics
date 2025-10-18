package br.ifsp.edu.prw3.mechanics.repository;

import br.ifsp.edu.prw3.mechanics.model.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto,Long> {
    List<Conserto> findAllByAtivoTrue();
}
