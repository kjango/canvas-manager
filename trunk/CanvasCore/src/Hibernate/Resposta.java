package Hibernate;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe que representa os registros da tabela Resposta
 */
public class Resposta  implements java.io.Serializable {


     private int id;
     private Pergunta pergunta;
     private Projeto projeto;
     private String texto;
     private Date criadoEm;
     private Date atualizadoEm;
     private Set avaliacaos = new HashSet(0);

    public Resposta() {
    }

	
    public Resposta(int id, Pergunta pergunta, Projeto projeto, String texto, Date criadoEm, Date atualizadoEm) {
        this.id = id;
        this.pergunta = pergunta;
        this.projeto = projeto;
        this.texto = texto;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }
    public Resposta(int id, Pergunta pergunta, Projeto projeto, String texto, Date criadoEm, Date atualizadoEm, Set avaliacaos) {
       this.id = id;
       this.pergunta = pergunta;
       this.projeto = projeto;
       this.texto = texto;
       this.criadoEm = criadoEm;
       this.atualizadoEm = atualizadoEm;
       this.avaliacaos = avaliacaos;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Pergunta getPergunta() {
        return this.pergunta;
    }
    
    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
    public Projeto getProjeto() {
        return this.projeto;
    }
    
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    public String getTexto() {
        return this.texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
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
    public Set getAvaliacaos() {
        return this.avaliacaos;
    }
    
    public void setAvaliacaos(Set avaliacaos) {
        this.avaliacaos = avaliacaos;
    }




}


