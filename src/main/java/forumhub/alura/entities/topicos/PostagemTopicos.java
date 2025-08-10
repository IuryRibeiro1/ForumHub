package forumhub.alura.entities.topicos;

import forumhub.alura.entities.autor.Autor;
import forumhub.alura.entities.autor.DadosAutor;
import forumhub.alura.entities.autor.DadosAutorDetalhados;

import java.time.LocalDateTime;

public record PostagemTopicos(Long id, String titulo, String mensagem, DadosAutorDetalhados dadosAutor, String curso, StatusTopico statusTopico, LocalDateTime data) {


    public PostagemTopicos(Topicos topicos){
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensagem(), new DadosAutorDetalhados(topicos.getAutor()), topicos.getCurso() , topicos.getStatus(), topicos.getDataCriacao());
    }
}
