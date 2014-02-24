package Modelo;

public class PAvaliacaoCM {
	private String avaliador;;
	private String comentario;;
	private double nota;
	
	public PAvaliacaoCM(String avaliador, String comentario,
			double nota) {
		super();
		this.avaliador = avaliador;
		this.comentario = comentario;
		this.nota = nota;
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
