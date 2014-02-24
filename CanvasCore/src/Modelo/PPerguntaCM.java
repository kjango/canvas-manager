package Modelo;

public class PPerguntaCM {
	private String pergunta;
	private String resposta;
	private String dica;
//	private String nomeProjeto;
//	private String autor;
	private String avaliador;
	private String comentario;
	private double nota;
	
	public PPerguntaCM(String pergunta, String resposta, String dica,
			String avaliador, String comentario, double nota) {
		super();
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.dica = dica;
		this.avaliador = avaliador;
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
	
	
}
