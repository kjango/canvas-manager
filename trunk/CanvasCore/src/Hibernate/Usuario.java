package Hibernate;
// Generated 05/02/2014 15:44:05 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe que representa os registros da tabela Usuario
 */
public class Usuario  implements java.io.Serializable {


     private int id;
     private Status status;
     private Tipousuario tipousuario;
     private String nome;
     private String email;
     private String curso;
     private Date dataConclusaoCurso;
     private Date dataRegistro;
     private Date atualizadoEm;
     private Set projetos = new HashSet(0);
     private Credencial credencial;
     private Set equipes = new HashSet(0);
     private Set parecers = new HashSet(0);
     private Set historicos = new HashSet(0);
     private Set avaliacaos = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(int id, Status status, Tipousuario tipousuario, String nome, String email, Date dataConclusaoCurso, Date dataRegistro, Date atualizadoEm) {
        this.id = id;
        this.status = status;
        this.tipousuario = tipousuario;
        this.nome = nome;
        this.email = email;
        this.dataConclusaoCurso = dataConclusaoCurso;
        this.dataRegistro = dataRegistro;
        this.atualizadoEm = atualizadoEm;
    }
    public Usuario(int id, Status status, Tipousuario tipousuario, String nome, String email, String curso, Date dataConclusaoCurso, Date dataRegistro, Date atualizadoEm, Set projetos, Credencial credencial, Set equipes, Set parecers, Set historicos, Set avaliacaos) {
       this.id = id;
       this.status = status;
       this.tipousuario = tipousuario;
       this.nome = nome;
       this.email = email;
       this.curso = curso;
       this.dataConclusaoCurso = dataConclusaoCurso;
       this.dataRegistro = dataRegistro;
       this.atualizadoEm = atualizadoEm;
       this.projetos = projetos;
       this.credencial = credencial;
       this.equipes = equipes;
       this.parecers = parecers;
       this.historicos = historicos;
       this.avaliacaos = avaliacaos;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Status getStatus() {
        return this.status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    public Tipousuario getTipousuario() {
        return this.tipousuario;
    }
    
    public void setTipousuario(Tipousuario tipousuario) {
        this.tipousuario = tipousuario;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCurso() {
        return this.curso;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public Date getDataConclusaoCurso() {
        return this.dataConclusaoCurso;
    }
    
    public void setDataConclusaoCurso(Date dataConclusaoCurso) {
        this.dataConclusaoCurso = dataConclusaoCurso;
    }
    public Date getDataRegistro() {
        return this.dataRegistro;
    }
    
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
    public Date getAtualizadoEm() {
        return this.atualizadoEm;
    }
    
    public void setAtualizadoEm(Date atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
    public Set getProjetos() {
        return this.projetos;
    }
    
    public void setProjetos(Set projetos) {
        this.projetos = projetos;
    }
    public Credencial getCredencial() {
        return this.credencial;
    }
    
    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }
    public Set getEquipes() {
        return this.equipes;
    }
    
    public void setEquipes(Set equipes) {
        this.equipes = equipes;
    }
    public Set getParecers() {
        return this.parecers;
    }
    
    public void setParecers(Set parecers) {
        this.parecers = parecers;
    }
    public Set getHistoricos() {
        return this.historicos;
    }
    
    public void setHistoricos(Set historicos) {
        this.historicos = historicos;
    }
    public Set getAvaliacaos() {
        return this.avaliacaos;
    }
    
    public void setAvaliacaos(Set avaliacaos) {
        this.avaliacaos = avaliacaos;
    }




}


