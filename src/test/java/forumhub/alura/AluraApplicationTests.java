package forumhub.alura;

import forumhub.alura.controller.ForumController;
import forumhub.alura.entities.topicos.StatusTopico;
import forumhub.alura.entities.topicos.Topicos;
import forumhub.alura.repository.TopicosRepositorio;
import forumhub.alura.service.TopicoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class AluraApplicationTests {


	@Test
	void contextLoads() {
	}


}
