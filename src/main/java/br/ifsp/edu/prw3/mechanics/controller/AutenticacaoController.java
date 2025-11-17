package br.ifsp.edu.prw3.mechanics.controller;

import br.ifsp.edu.prw3.mechanics.dto.usuario.DadosAutenticacaoDto;
import br.ifsp.edu.prw3.mechanics.util.security.DadosToken;
import br.ifsp.edu.prw3.mechanics.model.Usuario;
import br.ifsp.edu.prw3.mechanics.util.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDto dados) {
        var token = new UsernamePasswordAuthenticationToken( dados.login(), dados.senha() );
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal() );
        return ResponseEntity
                .ok( new DadosToken(tokenJWT));
    }
}
