package forumhub.alura.controller;

import forumhub.alura.entities.autor.Autor;
import forumhub.alura.repository.UsuarioRepository;
import forumhub.alura.usuario.DadosCriarUsuario;
import forumhub.alura.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid DadosCriarUsuario dadosCriarUsuario) {
        String senhaCriptografada = passwordEncoder.encode(dadosCriarUsuario.senha());
        Usuario usuario = new Usuario(null, dadosCriarUsuario.login(), senhaCriptografada, new Autor(dadosCriarUsuario.dadosAutor()));
        repositorio.save(usuario);
        return ResponseEntity.ok().build();
    }
}
