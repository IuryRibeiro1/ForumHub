package forumhub.alura.controller;


import forumhub.alura.entities.autor.Autor;
import forumhub.alura.entities.respostas.DadosResposta;
import forumhub.alura.entities.respostas.Resposta;
import forumhub.alura.entities.topicos.*;
import forumhub.alura.repository.AutorRepositorio;
import forumhub.alura.repository.RespostaRepositorio;
import forumhub.alura.repository.TopicosRepositorio;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topico")
public class ForumController {

    @Autowired
    TopicosRepositorio topicosRepositorio;

    @Autowired
    AutorRepositorio autorRepositorio;

    @Autowired
    RespostaRepositorio respostaRepositorio;



    @PostMapping
    public ResponseEntity<?> criarTopico(@RequestBody @Valid DadosTopicos dadosTopicos) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();

        Autor autor = autorRepositorio.findByUsuarioLogin(login)
                .orElseThrow(() -> new EntityNotFoundException("Usuário autenticado não encontrado"));
        Topicos topico = new Topicos(dadosTopicos);
        topico.setAutor(autor);

        topicosRepositorio.save(topico);

        return ResponseEntity.ok().build();
    }
    @PostMapping("/resposta/{idTopico}")
    public void respostaTopico(@PathVariable Long idTopico, @RequestBody @Valid DadosResposta dadosResposta){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();

        Autor autor = autorRepositorio.findByUsuarioLogin(login)
                .orElseThrow(() -> new EntityNotFoundException("Usuário autenticado não encontrado"));

        var listagemTopicos = topicosRepositorio.getReferenceById(idTopico);

        Resposta resposta = new Resposta(dadosResposta);

        resposta.setAutor(autor);
        resposta.setTopicos(listagemTopicos);

        respostaRepositorio.save(resposta);

    }

    @GetMapping
    public ResponseEntity<Page<PostagemTopicos>> listar(Pageable pageable){
          var listagemTopicos = topicosRepositorio.findAll(pageable).map(PostagemTopicos::new);
        return ResponseEntity.ok(listagemTopicos);

    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalharTopico(@PathVariable Long id){
        var topicoDetalhado = topicosRepositorio.getReferenceById(id);

        return ResponseEntity.ok(new TopicoDetalhado(topicoDetalhado));

    }

    @PutMapping
    @Transactional
    public void atualizarTopico(@RequestBody @Valid AtualizarTopico atualizarTopico){
            var topicos = topicosRepositorio.getReferenceById(atualizarTopico.id());
            topicos.atualizarInformacoesTopicos(atualizarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarTopico(@PathVariable Long id){
        topicosRepositorio.deleteById(id);

    }

}



