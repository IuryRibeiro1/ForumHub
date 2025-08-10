package forumhub.alura.entities.perfil;


public class Perfil {


    private Long id;
    private String nome;

    public Perfil(DadosPerfil dadosPerfil){
        this.nome = dadosPerfil.nome();
    }

}
