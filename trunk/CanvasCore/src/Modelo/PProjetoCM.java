package Modelo;

public class PProjetoCM {

    private String statusProjeto;
    private String liderProjeto;
    private String nomeProjeto;
    private int idLider;
    private int myUserId;
    private int projetoId;

    public PProjetoCM(String statusProjeto, String liderProjeto,
            String nomeProjeto, int idLider, int myUserId, int projetoId) {
        super();
        this.statusProjeto = statusProjeto;
        this.liderProjeto = liderProjeto;
        this.nomeProjeto = nomeProjeto;
        this.idLider = idLider;
        this.myUserId = myUserId;
        this.projetoId = projetoId;
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public int getMyUserId() {
        return myUserId;
    }

    public void setMyUserId(int myUserId) {
        this.myUserId = myUserId;
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
