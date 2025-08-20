package forumhub.alura.repository;

import forumhub.alura.entities.respostas.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepositorio extends JpaRepository<Resposta, Long> {
}
