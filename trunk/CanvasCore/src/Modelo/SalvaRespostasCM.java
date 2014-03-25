/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author kji
 */
public class SalvaRespostasCM {
    int perguntaId;
    int projetoId;
    String resposta;

    public SalvaRespostasCM(int perguntaId, int projetoId, String resposta) {
        this.perguntaId = perguntaId;
        this.projetoId = projetoId;
        this.resposta = resposta;
    }

    public int getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(int perguntaId) {
        this.perguntaId = perguntaId;
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    
}
