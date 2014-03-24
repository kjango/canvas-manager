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
public class VProjetoUsuarioCM {
    private HashMap<String, ArrayList<PPerguntaCM>> conteudoPerguntas;
    private ArrayList<String> conteudoMembros;
    private String nomeProjeto;
    int idProjeto;
    String nomelider;
    int liderId;
    int statusProjeto;
    int myUserId;
    
    public VProjetoUsuarioCM(String nomeProjeto, int idProjeto, String nomelider, int liderId, int statusProjeto, int myUserId) {
        this.nomeProjeto = nomeProjeto;
        this.idProjeto = idProjeto;
        this.nomelider = nomelider;
        this.liderId = liderId;
        this.statusProjeto = statusProjeto;
        this.myUserId = myUserId;
    }

    public VProjetoUsuarioCM(HashMap<String, ArrayList<PPerguntaCM>> conteudoPerguntas, ArrayList<String> conteudoMembros, String nomeProjeto, int idProjeto, String nomelider, int liderId, int statusProjeto, int myUserId) {
        this.conteudoPerguntas = conteudoPerguntas;
        this.conteudoMembros = conteudoMembros;
        this.nomeProjeto = nomeProjeto;
        this.idProjeto = idProjeto;
        this.nomelider = nomelider;
        this.liderId = liderId;
        this.statusProjeto = statusProjeto;
        this.myUserId = myUserId;
    }

    public HashMap<String, ArrayList<PPerguntaCM>> getConteudoPerguntas() {
        return conteudoPerguntas;
    }

    public void setConteudoPerguntas(HashMap<String, ArrayList<PPerguntaCM>> conteudoPerguntas) {
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
        return myUserId;
    }

    public void setMyUserId(int myUserId) {
        this.myUserId = myUserId;
    }

}
