package Modelo;

import Hibernate.Avaliacao;
import Hibernate.Projeto;
import Hibernate.Situacao;
import Hibernate.Usuario;
import java.util.ArrayList;

/**
 *
 * @author ROSANA
 */
public class ProjetoCM {
    private Usuario lider;
    private ArrayList<Usuario> equipe;
    private Projeto projeto;
    private ArrayList<PerguntaCM> perguntas;
    private ArrayList<Avaliacao> avaliacao;
    private ParecerCM parecer;
    private Situacao situacao;

    public ProjetoCM(Usuario lider, ArrayList<Usuario> equipe, Projeto projeto, ArrayList<PerguntaCM> perguntas, ArrayList<Avaliacao> avaliacao, ParecerCM parecer, Situacao situacao) {
        this.lider = lider;
        this.equipe = equipe;
        this.projeto = projeto;
        this.perguntas = perguntas;
        this.avaliacao = avaliacao;
        this.parecer = parecer;
        this.situacao = situacao;
    }

    public Usuario getLider() {
        return lider;
    }

    public void setLider(Usuario lider) {
        this.lider = lider;
    }

    public ArrayList<Usuario> getEquipe() {
        return equipe;
    }

    public void setEquipe(ArrayList<Usuario> equipe) {
        this.equipe = equipe;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public ArrayList<PerguntaCM> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(ArrayList<PerguntaCM> perguntas) {
        this.perguntas = perguntas;
    }

    public ArrayList<Avaliacao> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(ArrayList<Avaliacao> avaliacao) {
        this.avaliacao = avaliacao;
    }

    public ParecerCM getParecer() {
        return parecer;
    }

    public void setParecer(ParecerCM parecer) {
        this.parecer = parecer;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
       
}
