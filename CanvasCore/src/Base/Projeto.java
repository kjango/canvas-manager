/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Base;

import java.sql.Date;

/**
 *
 * @author Rosana
 */
public class Projeto {
    
    private int id;
    private String nome;
    private int lider;
    private int id_situacao;
    private Date criado_em;
    private Date atualizado_em;

    public Projeto(int id, String nome, int lider, int id_situacao, Date criado_em, Date atualizado_em) {
        this.id = id;
        this.nome = nome;
        this.lider = lider;
        this.id_situacao = id_situacao;
        this.criado_em = criado_em;
        this.atualizado_em = atualizado_em;
    }

    public Projeto(String nomeProj, int idLider, int id_situacao) {
        this.nome = nomeProj;
        this.lider = idLider;
        this.id_situacao = id_situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLider() {
        return lider;
    }

    public void setLider(int lider) {
        this.lider = lider;
    }

    public int getId_situacao() {
        return id_situacao;
    }

    public void setId_situacao(int id_situacao) {
        this.id_situacao = id_situacao;
    }

    public Date getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(Date criado_em) {
        this.criado_em = criado_em;
    }

    public Date getAtualizado_em() {
        return atualizado_em;
    }

    public void setAtualizado_em(Date atualizado_em) {
        this.atualizado_em = atualizado_em;
    }
    
    
}
