package Hibernate;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Tabela que representa a tabela Equipe
 */
public class Equipe  implements java.io.Serializable {


     private EquipeId id;
     private Usuario usuario;
     private Projeto projeto;
     private Date adicionadoEm;

    public Equipe() {
    }

    public Equipe(EquipeId id, Usuario usuario, Projeto projeto, Date adicionadoEm) {
       this.id = id;
       this.usuario = usuario;
       this.projeto = projeto;
       this.adicionadoEm = adicionadoEm;
    }
   
    public EquipeId getId() {
        return this.id;
    }
    
    public void setId(EquipeId id) {
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
    public Date getAdicionadoEm() {
        return this.adicionadoEm;
    }
    
    public void setAdicionadoEm(Date adicionadoEm) {
        this.adicionadoEm = adicionadoEm;
    }




}


