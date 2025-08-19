package forumhub.alura.repository;

import forumhub.alura.entities.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface AutorRepositorio extends JpaRepository<Autor , Long> {

    @Query("SELECT a FROM Autor a WHERE a.usuario.login = :login")
    Optional<Autor> findByUsuarioLogin(@Param("login") String login);
}

