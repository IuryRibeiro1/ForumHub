package forumhub.alura.repository;

import forumhub.alura.entities.topicos.Topicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface TopicosRepositorio extends JpaRepository<Topicos, Long> {

}


