package Hibernate;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Classe que representa os registros da tabela Resultado
 */
public class Resultado  implements java.io.Serializable {


     private int id;
     private String descricao;
     private Set parecers = new HashSet(0);

    public Resultado() {
    }

	
    public Resultado(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    public Resultado(int id, String descricao, Set parecers) {
       this.id = id;
       this.descricao = descricao;
       this.parecers = parecers;
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
    public Set getParecers() {
        return this.parecers;
    }
    
    public void setParecers(Set parecers) {
        this.parecers = parecers;
    }




}


