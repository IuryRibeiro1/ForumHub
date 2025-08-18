package forumhub.alura.entities.respostas;

import forumhub.alura.entities.autor.Autor;
import forumhub.alura.entities.topicos.Topicos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "resposta")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;

    @ManyToOne
    private Topicos topicos;
    private LocalDateTime dataCriacao;

    @OneToMany
    private List<Autor> autor;

    private String solucao;

    public Resposta(DadosResposta dadosResposta){
        this.mensagem = dadosResposta.mensagem();
        this.topicos = dadosResposta.topicos();
        this.dataCriacao = LocalDateTime.now();
        this.autor = Collections.singletonList(dadosResposta.autor());
        this.solucao = dadosResposta.solucao();
    }

}
