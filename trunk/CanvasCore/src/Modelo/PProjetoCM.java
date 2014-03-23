package Modelo;

public class PProjetoCM {
	
    private String statusProjeto;
    private String liderProjeto;
    private String nomeProjeto;
    private int idLider;
    
	public PProjetoCM(String statusProjeto, String liderProjeto,
			String nomeProjeto, int idLider) {
		super();
		this.statusProjeto = statusProjeto;
		this.liderProjeto = liderProjeto;
		this.nomeProjeto = nomeProjeto;
                this.idLider = idLider;
	}

        public int getIdLider() {
		return idLider;
	}
	public void setIdLider(int idLider) {
		this.idLider = idLider;
	}
        
	public String getStatusProjeto() {
		return statusProjeto;
	}
	public void setStatusProjeto(String statusProjeto) {
		this.statusProjeto = statusProjeto;
	}
	public String getLiderProjeto() {
		return liderProjeto;
	}
	public void setLiderProjeto(String liderProjeto) {
		this.liderProjeto = liderProjeto;
	}
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
    
    
        
}
