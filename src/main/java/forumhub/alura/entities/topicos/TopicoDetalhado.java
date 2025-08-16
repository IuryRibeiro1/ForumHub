package forumhub.alura.entities.topicos;

import forumhub.alura.entities.autor.DadosAutorDetalhados;

import java.time.LocalDateTime;

public record TopicoDetalhado(Long id, String titulo, String mensagem, DadosAutorDetalhados dadosAutorDetalhados, String curso, LocalDateTime data) {


    public TopicoDetalhado(Topicos topicos){
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensagem(), new DadosAutorDetalhados(topicos.getAutor()) , topicos.getCurso(), topicos.getDataCriacao());
    }

}
