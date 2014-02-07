package Hibernate;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Classe que representa a tabela Parecer do Banco de Dados
 */
public class Parecer  implements java.io.Serializable {


     private int id;
     private Usuario usuario;
     private Projeto projeto;
     private Resultado resultado;
     private String comentario;
     private Date criadoEm;
     private Date modificadoEm;

    public Parecer() {
    }

	
    public Parecer(int id, Usuario usuario, Projeto projeto, Resultado resultado, Date criadoEm, Date modificadoEm) {
        this.id = id;
        this.usuario = usuario;
        this.projeto = projeto;
        this.resultado = resultado;
        this.criadoEm = criadoEm;
        this.modificadoEm = modificadoEm;
    }
    public Parecer(int id, Usuario usuario, Projeto projeto, Resultado resultado, String comentario, Date criadoEm, Date modificadoEm) {
       this.id = id;
       this.usuario = usuario;
       this.projeto = projeto;
       this.resultado = resultado;
       this.comentario = comentario;
       this.criadoEm = criadoEm;
       this.modificadoEm = modificadoEm;
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
    public Projeto getProjeto() {
        return this.projeto;
    }
    
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    public Resultado getResultado() {
        return this.resultado;
    }
    
    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
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
    public Date getModificadoEm() {
        return this.modificadoEm;
    }
    
    public void setModificadoEm(Date modificadoEm) {
        this.modificadoEm = modificadoEm;
    }




}


