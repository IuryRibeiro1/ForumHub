package forumhub.alura.repository;

import forumhub.alura.entities.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepositorio extends JpaRepository<Autor , Long> {


}
