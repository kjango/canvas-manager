package Hibernate;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Classe que representa os registros da tabela Situacao
 */
public class Situacao  implements java.io.Serializable {


     private int id;
     private String descricao;
     private Set projetos = new HashSet(0);

    public Situacao() {
    }

	
    public Situacao(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    public Situacao(int id, String descricao, Set projetos) {
       this.id = id;
       this.descricao = descricao;
       this.projetos = projetos;
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
    public Set getProjetos() {
        return this.projetos;
    }
    
    public void setProjetos(Set projetos) {
        this.projetos = projetos;
    }




}


