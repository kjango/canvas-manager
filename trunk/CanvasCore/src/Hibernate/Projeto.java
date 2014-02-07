package Hibernate;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe que representa os registros da tabela Projeto
 */
public class Projeto  implements java.io.Serializable {


     private int id;
     private Situacao situacao;
     private Usuario usuario;
     private String nome;
     private Date criadoEm;
     private Date atualizadoEm;
     private Set respostas = new HashSet(0);
     private Set parecers = new HashSet(0);
     private Set equipes = new HashSet(0);

    public Projeto() {
    }

	
    public Projeto(int id, Situacao situacao, Usuario usuario, String nome, Date criadoEm, Date atualizadoEm) {
        this.id = id;
        this.situacao = situacao;
        this.usuario = usuario;
        this.nome = nome;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }
    public Projeto(int id, Situacao situacao, Usuario usuario, String nome, Date criadoEm, Date atualizadoEm, Set respostas, Set parecers, Set equipes) {
       this.id = id;
       this.situacao = situacao;
       this.usuario = usuario;
       this.nome = nome;
       this.criadoEm = criadoEm;
       this.atualizadoEm = atualizadoEm;
       this.respostas = respostas;
       this.parecers = parecers;
       this.equipes = equipes;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Situacao getSituacao() {
        return this.situacao;
    }
    
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
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
    public Set getRespostas() {
        return this.respostas;
    }
    
    public void setRespostas(Set respostas) {
        this.respostas = respostas;
    }
    public Set getParecers() {
        return this.parecers;
    }
    
    public void setParecers(Set parecers) {
        this.parecers = parecers;
    }
    public Set getEquipes() {
        return this.equipes;
    }
    
    public void setEquipes(Set equipes) {
        this.equipes = equipes;
    }




}


