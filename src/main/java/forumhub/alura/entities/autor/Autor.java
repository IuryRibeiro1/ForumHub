package forumhub.alura.entities.autor;

import forumhub.alura.entities.topicos.Topicos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class Autor {

    private String nome;
    private String email;

    public Autor(DadosAutor dadosAutor){
        this.nome = dadosAutor.nome();
        this.email = dadosAutor.email();

    }

}
