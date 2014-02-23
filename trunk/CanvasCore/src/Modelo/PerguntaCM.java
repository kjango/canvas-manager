package Modelo;

import Base.Pergunta;
import Base.Resposta;

/**
 * Classe da camada de modelo para as perguntas
 * @author ROSANA
 */
public class PerguntaCM {
    private Pergunta pergunta;
    private Resposta resposta;

    /**
     * Construtor da classe
     * @param pergunta Objeto pergunta contendo a pergunta do Canvas
     * @param resposta Objeto resposta contendo a resposta à pergunta do Canvas
     */
    public PerguntaCM(Pergunta pergunta, Resposta resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    /**
     * Método que retorna o objeto pergunta
     * @return Objeto pergunta contendo a pergunta do Canvas
     */
    public Pergunta getPergunta() {
        return pergunta;
    }

    /**
     * Método que define o objeto pergunta
     * @param pergunta Objeto pergunta contendo a pergunta do Canvas
     */
    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    /**
     * Método que retorna o objeto resposta
     * @return Objeto resposta contendo a resposta à pergunta do Canvas
     */
    public Resposta getResposta() {
        return resposta;
    }

    /**
     * Método que define o objeto resposta
     * @param resposta Objeto resposta contendo a resposta à pergunta do Canvas
     */
    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }
    
    
}
