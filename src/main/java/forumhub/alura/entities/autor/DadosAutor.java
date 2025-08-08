package forumhub.alura.entities.autor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAutor(
        @NotBlank
        String nome,

        @NotBlank
        String email)

        {
}
