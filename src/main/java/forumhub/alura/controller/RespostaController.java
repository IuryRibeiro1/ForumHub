package forumhub.alura.controller;

import forumhub.alura.entities.respostas.DadosResposta;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resposta")
public class RespostaController {



    public void postarResposta(@RequestBody @Valid DadosResposta resposta){

    }

}
