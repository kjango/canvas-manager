package Modelo;

public class PPerguntaAvaliacaoCM {

    private String pergunta;
    private int perguntaId;
    private String resposta;
    private int respostaId;
    private String dica;
    private String grupo;
    private String avaliador;
    private int avaliadorId;
    private String comentario;
    private double nota;

    public PPerguntaAvaliacaoCM(String pergunta, int perguntaId, String resposta, int respostaId, String dica, String grupo, String avaliador, int avaliadorId, String comentario, double nota) {
        this.pergunta = pergunta;
        this.perguntaId = perguntaId;
        this.resposta = resposta;
        this.respostaId = respostaId;
        this.dica = dica;
        this.grupo = grupo;
        this.avaliador = avaliador;
        this.avaliadorId = avaliadorId;
        this.comentario = comentario;
        this.nota = nota;
    }

    public PPerguntaAvaliacaoCM(int respostaId, double nota, String comentario, int avaliadorId, String avaliador) {
        this.respostaId = respostaId;
        this.avaliador = avaliador;
        this.avaliadorId = avaliadorId;
        this.comentario = comentario;
        this.nota = nota;
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

    public String getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(String avaliador) {
        this.avaliador = avaliador;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
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

    public int getRespostaId() {
        return respostaId;
    }

    public void setRespostaId(int respostaId) {
        this.respostaId = respostaId;
    }

    public int getAvaliadorId() {
        return avaliadorId;
    }

    public void setAvaliadorId(int avaliadorId) {
        this.avaliadorId = avaliadorId;
    }

}
