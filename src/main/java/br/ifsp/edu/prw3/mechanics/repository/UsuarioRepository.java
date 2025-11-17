package br.ifsp.edu.prw3.mechanics.repository;

import br.ifsp.edu.prw3.mechanics.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    UserDetails findByLogin(String login);
}
