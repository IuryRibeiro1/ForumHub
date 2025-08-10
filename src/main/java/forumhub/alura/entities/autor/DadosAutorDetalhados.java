package forumhub.alura.entities.autor;

public record DadosAutorDetalhados(String nome, String email) {


    public DadosAutorDetalhados(Autor autor){
        this(autor.getNome(), autor.getEmail());
    }

}
