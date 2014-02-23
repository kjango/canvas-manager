package Modelo;

import Base.Avaliacao;
import Base.Projeto;
import Base.Situacao;
import Base.Usuario;
import java.util.ArrayList;

/**
 * Classe da camada de modelo para os projetos
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

    /**
     * Construtor da classe
     * @param lider Objeto usuario contendo o líder do projeto
     * @param equipe ArrayList de objeto usuario contendo a equipe do projeto
     * @param projeto Objeto projeto contendo os dados do projeto
     * @param perguntas ArrayList de perguntaCM com as perguntas do Canvas
     * @param avaliacao ArrayList de objetos avaliacao contendo a avaliação para as perguntas
     * @param parecer Objeto parecerCM contendo o parecer do administrador
     * @param situacao Objeto situacao informando a situação do projeto
     */
    public ProjetoCM(Usuario lider, ArrayList<Usuario> equipe, Projeto projeto, ArrayList<PerguntaCM> perguntas, ArrayList<Avaliacao> avaliacao, ParecerCM parecer, Situacao situacao) {
        this.lider = lider;
        this.equipe = equipe;
        this.projeto = projeto;
        this.perguntas = perguntas;
        this.avaliacao = avaliacao;
        this.parecer = parecer;
        this.situacao = situacao;
    }

    /**
     * Método que retorna o objeto usuario que seja o líder do projeto
     * @return Objeto usuario contendo o líder do projeto
     */
    public Usuario getLider() {
        return lider;
    }

    /**
     * Método que define o objeto usuario que seja o líder do projeto
     * @param lider Objeto usuario contendo o líder do projeto
     */
    public void setLider(Usuario lider) {
        this.lider = lider;
    }

    /**
     * Método que retorna um arrayList de objetos usuario que formam parte da equipe
     * @return ArrayList de objeto usuario contendo a equipe do projeto
     */
    public ArrayList<Usuario> getEquipe() {
        return equipe;
    }

    /**
     * Método que define um arrayList de objetos usuario que formam parte da equipe
     * @param equipe ArrayList de objeto usuario contendo a equipe do projeto
     */
    public void setEquipe(ArrayList<Usuario> equipe) {
        this.equipe = equipe;
    }

    /**
     * Método que retorna o objeto projeto
     * @return Objeto projeto contendo os dados do projeto
     */
    public Projeto getProjeto() {
        return projeto;
    }

    /**
     * Método que deine o objeto projeto
     * @param projeto Objeto projeto contendo os dados do projeto
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    /**
     * Método que retorna um arrayList de objetos pergunta
     * @return ArrayList de perguntaCM com as perguntas do Canvas
     */
    public ArrayList<PerguntaCM> getPerguntas() {
        return perguntas;
    }

    /**
     *Método que define um arrayList de objetos pergunta
     * @param perguntas ArrayList de perguntaCM com as perguntas do Canvas
     */
    public void setPerguntas(ArrayList<PerguntaCM> perguntas) {
        this.perguntas = perguntas;
    }

    /**
     *Método que retorna um arrayList de objetos avaliacao
     * @return ArrayList de objetos avaliacao contendo a avaliação para as perguntas
     */
    public ArrayList<Avaliacao> getAvaliacao() {
        return avaliacao;
    }

    /**
     *Método que define um arrayList de objetos avaliacao
     * @param avaliacao ArrayList de objetos avaliacao contendo a avaliação para as perguntas
     */
    public void setAvaliacao(ArrayList<Avaliacao> avaliacao) {
        this.avaliacao = avaliacao;
    }

    /**
     * Método que retorna o objeto parecerCM
     * @return Objeto parecerCM contendo o parecer do administrador
     */
    public ParecerCM getParecer() {
        return parecer;
    }

    /**
     * Método que define o objeto parecerCM
     * @param parecer Objeto parecerCM contendo o parecer do administrador
     */
    public void setParecer(ParecerCM parecer) {
        this.parecer = parecer;
    }

    /**
     * Método que retorna o objeto situacao
     * @return Objeto situacao informando a situação do projeto
     */
    public Situacao getSituacao() {
        return situacao;
    }

    /**
     * Método que define o objeto situacao
     * @param situacao Objeto situacao informando a situação do projeto
     */
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
       
}
