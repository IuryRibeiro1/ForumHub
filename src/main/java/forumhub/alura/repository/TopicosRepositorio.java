package forumhub.alura.repository;

import forumhub.alura.entities.topicos.Topicos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TopicosRepositorio extends JpaRepository<Topicos, Long> {


    Optional<Topicos> findByTitulo(String titulo);

    Optional<Topicos> findByMensagem(String mensagem);



}


