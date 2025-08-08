package forumhub.alura.entities.topicos;

import forumhub.alura.entities.autor.Autor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Topicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    @Enumerated(EnumType.STRING)
    private StatusTopico status;
    @Embedded
    private Autor autor;
    private String curso;
    private String resposta;


    public Topicos(DadosTopicos dadosTopicos){
        this.titulo = dadosTopicos.titulo();
        this.mensagem = dadosTopicos.mensagem();
        this.dataCriacao = dadosTopicos.dataCriacao();
        this.status = dadosTopicos.status();
        this.autor = dadosTopicos.autor();
        this.curso = dadosTopicos.curso();
        this.resposta = dadosTopicos.resposta();
    }



}
