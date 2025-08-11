package forumhub.alura.entities.autor;

public record DadosAutorDetalhados(Long id, String nome, String email) {

    public DadosAutorDetalhados(Autor autor){
        this(autor.getId(), autor.getNome(), autor.getEmail());
    }

}
