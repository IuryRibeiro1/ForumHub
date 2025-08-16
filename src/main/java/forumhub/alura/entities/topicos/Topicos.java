package forumhub.alura.entities.topicos;

import forumhub.alura.entities.autor.Autor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "topicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Topicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    private String curso;


    public Topicos(DadosTopicos dadosTopicos){
        this.titulo = dadosTopicos.titulo();
        this.mensagem = dadosTopicos.mensagem();
        this.curso = dadosTopicos.curso();
        this.status = StatusTopico.AGUARDANDO_AVALIACAO;
        this.dataCriacao = LocalDateTime.now();
        this.curso = "Desenvolvimento de sistemas";
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