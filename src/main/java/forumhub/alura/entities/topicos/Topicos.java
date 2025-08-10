package forumhub.alura.entities.topicos;

import forumhub.alura.entities.autor.Autor;
import forumhub.alura.entities.autor.DadosAutor;
import forumhub.alura.entities.autor.DadosAutorDetalhados;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;
    private String curso;


    public Topicos(DadosTopicos dadosTopicos){
        this.titulo = dadosTopicos.titulo();
        this.mensagem = dadosTopicos.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.status = dadosTopicos.status();
        this.autor = new Autor(dadosTopicos.autor());
        this.curso = dadosTopicos.curso();
    }

    public void atualizarInformacoesTopicos(AtualizarTopico atualizarTopico){
        if(atualizarTopico.titulo() != null){
            this.titulo = atualizarTopico.titulo();
        }
        if(atualizarTopico.mensagem() != null){
            this.mensagem = atualizarTopico.mensagem();
        }
        if(atualizarTopico.curso() != null){
            this.curso = atualizarTopico.curso();;
        }


    }


}
