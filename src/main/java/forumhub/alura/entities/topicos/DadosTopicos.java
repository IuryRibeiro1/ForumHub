package forumhub.alura.entities.topicos;

import forumhub.alura.entities.autor.Autor;
import forumhub.alura.entities.autor.DadosAutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosTopicos(

        @NotBlank(message = "O campo Titulo é obrigatório")
        String titulo,

        @NotBlank(message = "O campo Mensagem é obrigatório")
        String mensagem,

        @NotNull(message = "O campo autor é obrigatória, preencha nome e email")
        @Valid
        DadosAutor autor,

        @NotBlank(message = "O campo Curso é obrigatório")
        String curso) {
}
