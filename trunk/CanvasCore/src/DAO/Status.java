package DAO;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Status generated by hbm2java
 */
public class Status  implements java.io.Serializable {


     private int id;
     private String descricao;
     private Set usuarios = new HashSet(0);

    public Status() {
    }

	
    public Status(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    public Status(int id, String descricao, Set usuarios) {
       this.id = id;
       this.descricao = descricao;
       this.usuarios = usuarios;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


