package Modelo;

import Hibernate.Pergunta;
import Hibernate.Resposta;

/**
 *
 * @author ROSANA
 */
public class PerguntaCM {
    private Pergunta pergunta;
    private Resposta resposta;

    public PerguntaCM(Pergunta pergunta, Resposta resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }
    
    
}
