package Modelo;

/**
 *
 * @author Francisco
 */
public class PPerguntaCM {

    private String pergunta;
    private String resposta;
    private String dica;
    private String grupo;
    private int perguntaId;
    //private int respostaId;
//	private String nomeProjeto;
//	private String autor;

    public PPerguntaCM(String pergunta, String resposta, String dica,
        String grupo, int perguntaId) {
        super();
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.dica = dica;
        this.grupo = grupo;
        this.perguntaId = perguntaId;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(int perguntaId) {
        this.perguntaId = perguntaId;
    }

}
