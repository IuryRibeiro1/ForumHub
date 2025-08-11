package forumhub.alura.entities.autor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import forumhub.alura.entities.topicos.Topicos;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "autor")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @OneToMany(mappedBy = "autor")
    private List<Topicos> topicos;

    public Autor(DadosAutor dadosAutor){
        this.nome = dadosAutor.nome();
        this.email = dadosAutor.email();

    }


}