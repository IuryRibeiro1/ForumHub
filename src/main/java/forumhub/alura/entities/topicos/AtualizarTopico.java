package forumhub.alura.entities.topicos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarTopico(

        @NotNull(message = "O campo Id é obrigatório")
        Long id,

        @NotBlank(message = "O campo titulo é obrigatório")
        String titulo,

        @NotBlank(message = "O campo mensagem é obrigatório")
        String mensagem,

        @NotBlank(message = "O campo curso é obrigatório")
        String curso){

}



