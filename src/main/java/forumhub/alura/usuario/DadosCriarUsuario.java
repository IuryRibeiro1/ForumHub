package forumhub.alura.usuario;

import forumhub.alura.entities.autor.DadosAutor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCriarUsuario(

        @NotBlank
        String login,
        @NotBlank
        String senha,
        @NotNull
        DadosAutor dadosAutor) {
}
