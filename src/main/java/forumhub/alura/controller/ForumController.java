package forumhub.alura.controller;

import forumhub.alura.entities.autor.DadosAutor;
import forumhub.alura.entities.topicos.DadosTopicos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("topico")
public class ForumController {

    @PostMapping
    public void retornarPost(@RequestBody DadosTopicos dadosTopicos) {
        System.out.println(dadosTopicos);
    }

}



