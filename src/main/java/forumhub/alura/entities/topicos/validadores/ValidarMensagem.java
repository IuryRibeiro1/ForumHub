package forumhub.alura.entities.topicos.validadores;

import forumhub.alura.entities.topicos.DadosTopicos;
import forumhub.alura.repository.TopicosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMensagem implements ValidarTopico{

    @Autowired
    TopicosRepositorio repositorio;

    @Override
    public void validar(DadosTopicos dadosTopicos) {
        var validarMensagem = repositorio.findByMensagem(dadosTopicos.mensagem());
        if(validarMensagem.isPresent()){
            throw new IllegalArgumentException("Já existe uma mensagem identica registrada");
        }
    }
}
