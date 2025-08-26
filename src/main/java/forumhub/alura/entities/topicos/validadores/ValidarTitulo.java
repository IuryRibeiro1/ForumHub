package forumhub.alura.entities.topicos.validadores;

import forumhub.alura.entities.topicos.DadosTopicos;
import forumhub.alura.repository.TopicosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarTitulo implements ValidarTopico{

    @Autowired
    TopicosRepositorio repositorio;

    @Override
    public void validar(DadosTopicos dadosTopicos) {
        var verificarTitulo = repositorio.findByTitulo(dadosTopicos.titulo());
        if(verificarTitulo.isPresent()){
            throw new IllegalArgumentException("Já possui um título registrado igual");
        }
    }
}
