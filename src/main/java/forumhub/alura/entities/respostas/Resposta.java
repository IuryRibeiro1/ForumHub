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

    @ManyToOne
    private Autor autor;

    private String solucao;

    public Resposta(DadosResposta dadosResposta){
        this.mensagem = dadosResposta.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.solucao = dadosResposta.solucao();
    }

}
