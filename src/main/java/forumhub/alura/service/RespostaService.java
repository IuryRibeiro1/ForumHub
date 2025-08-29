package forumhub.alura.service;

import forumhub.alura.entities.autor.Autor;
import forumhub.alura.entities.respostas.DadosResposta;
import forumhub.alura.entities.respostas.Resposta;
import forumhub.alura.entities.respostas.RespostaDTO;
import forumhub.alura.repository.AutorRepositorio;
import forumhub.alura.repository.RespostaRepositorio;
import forumhub.alura.repository.TopicosRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class RespostaService {

        @Autowired
        private RespostaRepositorio respostaRepositorio;

        @Autowired
        private TopicosRepositorio topicosRepositorio;

        @Autowired
        private AutorRepositorio autorRepositorio;

        public RespostaDTO responderTopico(Long idTopico, DadosResposta dadosResposta) {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String login = authentication.getName();

            Autor autor = autorRepositorio.findByUsuarioLogin(login)
                    .orElseThrow(() -> new EntityNotFoundException("Usuário autenticado não encontrado"));

            var topico = topicosRepositorio.findById(idTopico)
                    .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado"));


            Resposta resposta = new Resposta(dadosResposta);
            resposta.setAutor(autor);
            resposta.setTopicos(topico);


            respostaRepositorio.save(resposta);


            return new RespostaDTO(resposta);
        }
    }

