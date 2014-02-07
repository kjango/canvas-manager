package Hibernate;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0


import Util.IODica;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe que representa os registros da tabela Pergunta
 */
public class Pergunta  implements java.io.Serializable {


     private int id;
     private String descricao;
     private String dica;
     private Set respostas = new HashSet(0);

    public Pergunta() {
    }

	
    public Pergunta(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    public Pergunta(int id, String descricao, Set respostas) {
       this.id = id;
       this.descricao = descricao;
       this.respostas = respostas;
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
    public Set getRespostas() {
        return this.respostas;
    }
    
    public void setRespostas(Set respostas) {
        this.respostas = respostas;
    }

    public String getDica() throws IOException{
        return IODica.getText(id);
    }            


}


