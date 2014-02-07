package Hibernate;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Classe que representa a tabela Credencial
 */
public class Credencial  implements java.io.Serializable {


     private int idUsuario;
     private Usuario usuario;
     private String senha;
     private Date atualizadoEm;

    public Credencial() {
    }

    public Credencial(Usuario usuario, String senha, Date atualizadoEm) {
       this.usuario = usuario;
       this.senha = senha;
       this.atualizadoEm = atualizadoEm;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Date getAtualizadoEm() {
        return this.atualizadoEm;
    }
    
    public void setAtualizadoEm(Date atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }




}


