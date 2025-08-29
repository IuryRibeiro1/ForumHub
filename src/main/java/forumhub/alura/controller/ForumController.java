package forumhub.alura.controller;


import forumhub.alura.entities.autor.Autor;
import forumhub.alura.entities.respostas.DadosResposta;
import forumhub.alura.entities.respostas.Resposta;
import forumhub.alura.entities.respostas.RespostaDTO;
import forumhub.alura.entities.topicos.*;
import forumhub.alura.entities.topicos.validadores.ValidarTopico;
import forumhub.alura.repository.AutorRepositorio;
import forumhub.alura.repository.RespostaRepositorio;
import forumhub.alura.repository.TopicosRepositorio;

import forumhub.alura.service.RespostaService;
import forumhub.alura.service.TopicoService;
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

import java.util.List;

@RestController
@RequestMapping("topico")
public class ForumController {

    @Autowired
    TopicosRepositorio topicosRepositorio;

    @Autowired
    AutorRepositorio autorRepositorio;

    @Autowired
    RespostaRepositorio respostaRepositorio;

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private RespostaService respostaService;

    @PostMapping
    public ResponseEntity<PostagemTopicos> criarTopico(@RequestBody @Valid DadosTopicos dadosTopicos) {

        var dto = topicoService.postagemTopicos(dadosTopicos);
        return ResponseEntity.ok(dto);

    }
    @PostMapping("/resposta/{idTopico}")
    public ResponseEntity<RespostaDTO> respostaTopico(@PathVariable Long idTopico, @RequestBody @Valid DadosResposta dadosResposta){

        var dto = respostaService.responderTopico(idTopico,dadosResposta);
        return ResponseEntity.ok(dto);

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



