package Modelo;

public class PPerguntaCM {
	private String pergunta;
	private String resposta;
	private String dica;
	
	public PPerguntaCM(String pergunta, String resposta, String dica) {
		super();
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.dica = dica;
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
}
