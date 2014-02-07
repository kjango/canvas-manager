package Hibernate;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0



/**
 * Classe que representa a tabela Historico
 * Responsável por salvar os logs da aplicação
 */
public class Historico  implements java.io.Serializable {


     private int id;
     private Usuario usuario;
     private String texto;

    public Historico() {
    }

    public Historico(int id, Usuario usuario, String texto) {
       this.id = id;
       this.usuario = usuario;
       this.texto = texto;
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
    public String getTexto() {
        return this.texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }




}


