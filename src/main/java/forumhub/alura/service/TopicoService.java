package forumhub.alura.service;

import forumhub.alura.entities.autor.Autor;
import forumhub.alura.entities.topicos.DadosTopicos;
import forumhub.alura.entities.topicos.PostagemTopicos;
import forumhub.alura.entities.topicos.Topicos;
import forumhub.alura.entities.topicos.validadores.ValidarTopico;
import forumhub.alura.repository.AutorRepositorio;
import forumhub.alura.repository.TopicosRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicosRepositorio topicosRepositorio;

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Autowired
    private List<ValidarTopico> validadores;

    public PostagemTopicos postagemTopicos(DadosTopicos dadosTopicos) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();

        Autor autor = autorRepositorio.findByUsuarioLogin(login)
                .orElseThrow(() -> new EntityNotFoundException("Usuário autenticado não encontrado"));

        validadores.forEach(v -> v.validar(dadosTopicos));

        Topicos topico = new Topicos(dadosTopicos);
        topico.setAutor(autor);


        topicosRepositorio.save(topico);

        return new PostagemTopicos(topico);
    }
}

