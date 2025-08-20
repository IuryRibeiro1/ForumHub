package forumhub.alura.entities.respostas;

import forumhub.alura.entities.autor.Autor;
import forumhub.alura.entities.topicos.Topicos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosResposta(

        @NotBlank
        String mensagem,


        @NotBlank
        String solucao) {
}
