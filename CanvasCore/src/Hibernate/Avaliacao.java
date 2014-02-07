package Hibernate;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Classe que representa a tabela Avaliacao
 */
public class Avaliacao  implements java.io.Serializable {


     private int id;
     private Usuario usuario;
     private Resposta resposta;
     private int nota;
     private String comentario;
     private Date criadoEm;
     private Date atualizadoEm;

    public Avaliacao() {
    }

	
    public Avaliacao(int id, Usuario usuario, Resposta resposta, int nota, Date criadoEm, Date atualizadoEm) {
        this.id = id;
        this.usuario = usuario;
        this.resposta = resposta;
        this.nota = nota;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }
    public Avaliacao(int id, Usuario usuario, Resposta resposta, int nota, String comentario, Date criadoEm, Date atualizadoEm) {
       this.id = id;
       this.usuario = usuario;
       this.resposta = resposta;
       this.nota = nota;
       this.comentario = comentario;
       this.criadoEm = criadoEm;
       this.atualizadoEm = atualizadoEm;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Resposta getResposta() {
        return this.resposta;
    }
    
    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }
    public int getNota() {
        return this.nota;
    }
    
    public void setNota(int nota) {
        this.nota = nota;
    }
    public String getComentario() {
        return this.comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public Date getCriadoEm() {
        return this.criadoEm;
    }
    
    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }
    public Date getAtualizadoEm() {
        return this.atualizadoEm;
    }
    
    public void setAtualizadoEm(Date atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }




}


