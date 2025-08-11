package forumhub.alura.entities.topicos;

import forumhub.alura.entities.autor.Autor;
import forumhub.alura.entities.autor.DadosAutor;
import forumhub.alura.entities.autor.DadosAutorDetalhados;

import java.time.LocalDateTime;

public record PostagemTopicos(Long id, String titulo, String mensagem, LocalDateTime data, StatusTopico status, DadosAutorDetalhados autor , String curso ) {


    public PostagemTopicos(Topicos topicos){
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensagem(),  topicos.getDataCriacao(), topicos.getStatus(), new DadosAutorDetalhados(topicos.getAutor()) , topicos.getCurso());
    }
}
