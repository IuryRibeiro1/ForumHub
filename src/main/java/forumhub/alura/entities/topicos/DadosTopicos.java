package forumhub.alura.entities.topicos;

import forumhub.alura.entities.autor.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosTopicos(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        LocalDateTime dataCriacao,

        @NotNull
        StatusTopico status,

        @NotBlank
        Autor autor,

        @NotBlank
        String curso,

        @NotBlank
        String resposta) {
}
