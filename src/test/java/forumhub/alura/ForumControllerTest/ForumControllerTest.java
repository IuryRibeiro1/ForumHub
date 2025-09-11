package forumhub.alura.ForumControllerTest;

import forumhub.alura.entities.autor.Autor;
import forumhub.alura.entities.topicos.DadosTopicos;
import forumhub.alura.entities.topicos.PostagemTopicos;
import forumhub.alura.entities.topicos.Topicos;
import forumhub.alura.entities.topicos.validadores.ValidarTopico;
import forumhub.alura.repository.AutorRepositorio;
import forumhub.alura.repository.TopicosRepositorio;
import forumhub.alura.repository.UsuarioRepository;
import forumhub.alura.service.TopicoService;
import forumhub.alura.usuario.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ForumControllerTest {

    @Autowired
    private TopicoService topicoService; // bean real do Spring

    @MockitoBean
    private AutorRepositorio autorRepositorio;

    @MockitoBean
    private TopicosRepositorio topicosRepositorio;

    @MockitoBean
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;
    private Autor autor;

    @BeforeEach
    void setUp() {
  
        autor = new Autor();
        autor.setNome("Iury Crespo");
        autor.setEmail("iury@email.com");

        usuario = new Usuario();
        usuario.setLogin("iuryLogin");
        usuario.setSenha("123456");
        usuario.setAutor(autor);
        autor.setUsuario(usuario);

        when(autorRepositorio.findByUsuarioLogin("iuryLogin"))
                .thenReturn(Optional.of(autor));

        when(topicosRepositorio.save(any(Topicos.class)))
                .thenAnswer(inv -> {
                    Topicos t = inv.getArgument(0);
                    t.setId(1L);
                    return t;
                });

        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(usuario.getLogin(), null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Test
    void deveCriarTopicoComSucesso() {
        DadosTopicos dados = new DadosTopicos("Titulo Teste", "Mensagem Teste", "Curso");


        PostagemTopicos resultado = topicoService.postagemTopicos(dados);

        assertNotNull(resultado, "O resultado não deveria ser null");
        assertEquals("Titulo Teste", resultado.titulo());
        assertEquals("Mensagem Teste", resultado.mensagem());

        verify(topicosRepositorio).save(any(Topicos.class));
    }
}