package forumhub.alura.entities.autor;

import forumhub.alura.usuario.Usuario;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAutor(

        @NotBlank(message = "O campo " + " nome " + "não pode ser vazio ")
        String nome,

        @NotBlank(message = "O campo " + " email " + "não pode ser vazio ")
        @Email
        String email)

        {
}
