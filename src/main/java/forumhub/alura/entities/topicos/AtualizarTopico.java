package forumhub.alura.entities.topicos;



public record AtualizarTopico(Long id, String titulo, String mensagem, String curso) {

    public AtualizarTopico(Topicos topicos){
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensagem(), topicos.getCurso());
    }

}
