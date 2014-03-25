/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kji
 */
public class VProjetoAvaliadorCM {
    private HashMap<String, ArrayList<PPerguntaAvaliacaoCM>> conteudoPerguntas;
    private ArrayList<String> conteudoMembros;
    private String nomeProjeto;
    int idProjeto;
    String nomelider;
    int liderId;
    int statusProjeto;
    int avaliadorId;
    
    public VProjetoAvaliadorCM(String nomeProjeto, int idProjeto, String nomelider, int liderId, int statusProjeto, int avaliadorId) {
        this.nomeProjeto = nomeProjeto;
        this.idProjeto = idProjeto;
        this.nomelider = nomelider;
        this.liderId = liderId;
        this.statusProjeto = statusProjeto;
        this.avaliadorId = avaliadorId;
    }

    public VProjetoAvaliadorCM(HashMap<String, ArrayList<PPerguntaAvaliacaoCM>> conteudoPerguntas, ArrayList<String> conteudoMembros, String nomeProjeto, int idProjeto, String nomelider, int liderId, int statusProjeto, int myUserId) {
        this.conteudoPerguntas = conteudoPerguntas;
        this.conteudoMembros = conteudoMembros;
        this.nomeProjeto = nomeProjeto;
        this.idProjeto = idProjeto;
        this.nomelider = nomelider;
        this.liderId = liderId;
        this.statusProjeto = statusProjeto;
        this.avaliadorId = myUserId;
    }

    public HashMap<String, ArrayList<PPerguntaAvaliacaoCM>> getConteudoPerguntas() {
        return conteudoPerguntas;
    }

    public void setConteudoPerguntas(HashMap<String, ArrayList<PPerguntaAvaliacaoCM>> conteudoPerguntas) {
        this.conteudoPerguntas = conteudoPerguntas;
    }

    public ArrayList<String> getConteudoMembros() {
        return conteudoMembros;
    }

    public void setConteudoMembros(ArrayList<String> conteudoMembros) {
        this.conteudoMembros = conteudoMembros;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNomelider() {
        return nomelider;
    }

    public void setNomelider(String nomelider) {
        this.nomelider = nomelider;
    }

    public int getLiderId() {
        return liderId;
    }

    public void setLiderId(int liderId) {
        this.liderId = liderId;
    }

    public int getStatusProjeto() {
        return statusProjeto;
    }

    public void setStatusProjeto(int statusProjeto) {
        this.statusProjeto = statusProjeto;
    }

    public int getMyUserId() {
        return avaliadorId;
    }

    public void setMyUserId(int myUserId) {
        this.avaliadorId = myUserId;
    }

}
