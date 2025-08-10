package forumhub.alura.controller;


import forumhub.alura.entities.topicos.*;
import forumhub.alura.repository.TopicosRepositorio;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topico")
public class ForumController {

    @Autowired
    TopicosRepositorio topicosRepositorio;

    @PostMapping
    @Transactional
    public void publicarPost(@RequestBody @Valid DadosTopicos dadosTopicos) {
        var topicos = new Topicos(dadosTopicos);
        topicosRepositorio.save(topicos);
    }
    @GetMapping
    public ResponseEntity<Page<PostagemTopicos>> listar(Pageable pageable){
          var listagemTopicos = topicosRepositorio.findById(pageable).map(PostagemTopicos::new);
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



