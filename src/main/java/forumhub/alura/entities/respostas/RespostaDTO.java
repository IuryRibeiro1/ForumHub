package forumhub.alura.entities.respostas;

public record RespostaDTO(String mensagem, String solucao) {

    public RespostaDTO(Resposta resposta){
        this(resposta.getMensagem(), resposta.getSolucao());
    }

}
