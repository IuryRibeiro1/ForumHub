package forumhub.alura.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import forumhub.alura.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public static final String usuarioToken = System.getenv("JWT_TOKEN");

    public String gerarToken(Usuario usuarios) {
        try {
            var algoritimo = Algorithm.HMAC256(usuarioToken);
            return JWT.create()
                    .withIssuer("ForumHub")
                    .withSubject(usuarios.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritimo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token" , exception);
        }
    }

    public String getSubject(String tokenJWT){
        try {
            var algoritimo = Algorithm.HMAC256(usuarioToken);
            return JWT.require(algoritimo)
                    .withIssuer("ForumHub")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token Inválido ou expirado!");
        }
    }

    private Instant dataExpiracao() {
        return (LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")));

    }
}
