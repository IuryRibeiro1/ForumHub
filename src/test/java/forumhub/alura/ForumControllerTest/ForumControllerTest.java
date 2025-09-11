package forumhub.alura.ForumControllerTest;

import forumhub.alura.entities.autor.Autor;
import forumhub.alura.entities.topicos.DadosTopicos;
import forumhub.alura.entities.topicos.PostagemTopicos;
import forumhub.alura.entities.topicos.Topicos;
import forumhub.alura.repository.TopicosRepositorio;
import forumhub.alura.repository.UsuarioRepository;
import forumhub.alura.service.TopicoService;
import forumhub.alura.usuario.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class ForumControllerTest {

    @MockitoBean
    UsuarioRepository usuarioRepository;

    @InjectMocks
    TopicoService topicoService;

    @MockitoBean
    TopicosRepositorio topicosRepositorio;

    @Test
    void autenticarUsuario() {

        Autor autor = new Autor();
        autor.setNome("Iury Crespo");
        autor.setEmail("iury@email.com");

        Usuario usuario = new Usuario();
        usuario.setLogin("iuryLogin");
        usuario.setSenha("123456");
        usuario.setAutor(autor);

        autor.setUsuario(usuario);

        Mockito.when(usuarioRepository.findByLogin("iuryLogin"))
                .thenReturn(usuario);

        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(usuario.getLogin(), usuario.getSenha(), usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);


    }
}


