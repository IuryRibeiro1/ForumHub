package forumhub.alura.repository;

import forumhub.alura.entities.topicos.Topicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface TopicosRepositorio extends JpaRepository<Topicos, Long> {

    @Query("SELECT t FROM Topicos t WHERE t.id != 0")
    Page<Topicos> findById(Pageable page);

}
