package forumhub.alura.entities.autor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import forumhub.alura.entities.topicos.Topicos;
import forumhub.alura.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "autor")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @OneToMany(mappedBy = "autor")
    private List<Topicos> topicos;

    @OneToOne(mappedBy = "autor")
    private Usuario usuario;

    public Autor(DadosAutor dadosAutor){
        this.nome = dadosAutor.nome();
        this.email = dadosAutor.email();

    }

    public void setEpisodio(List<Topicos> topico) {
        topico.forEach(e -> e.setAutor(this));
        topicos = topico;
    }
}